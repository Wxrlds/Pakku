package teksturepako.pakku.api.actions.sync

import com.github.michaelbull.result.onFailure
import com.github.michaelbull.result.onSuccess
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import teksturepako.pakku.api.actions.errors.ActionError
import teksturepako.pakku.api.actions.errors.AlreadyExists
import teksturepako.pakku.api.overrides.ProjectOverride
import teksturepako.pakku.io.tryToResult
import kotlin.io.path.createParentDirectories
import kotlin.io.path.exists
import kotlin.io.path.writeBytes

suspend fun Set<ProjectOverride>.sync(
    onError: suspend (error: ActionError) -> Unit,
    onSuccess: suspend (projectOverride: ProjectOverride) -> Unit,
): List<Job> = coroutineScope {
    this@sync.map { projectOverride ->
        launch {
            if (projectOverride.fullOutputPath.exists())
            {
                onError(AlreadyExists(projectOverride.fullOutputPath.toString()))
                return@launch
            }

            projectOverride.fullOutputPath.tryToResult {
                it.createParentDirectories()
                it.writeBytes(projectOverride.bytes)
            }.onSuccess {
                onSuccess(projectOverride)
            }.onFailure {
                onError(it)
            }
        }
    }
}
