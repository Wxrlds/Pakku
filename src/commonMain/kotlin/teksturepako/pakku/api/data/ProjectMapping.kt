package teksturepako.pakku.api.data

object ProjectMapping
{
    /**
     * A hardcoded lookup table for project slugs.
     * Format: "Modrinth Slug" to "CurseForge Slug"
     */
    private val table = mapOf(
        // "mr_slug" to "cf_slug",
        "distanthorizons" to "distant-horizons",
        "ebe" to "enhanced-block-entities",
        "ferrite-core" to "ferritecore-fabric",
        "iris" to "irisshaders",
        "modelfix" to "model-gap-fix",
        "texel-chameleon" to "chameleon",
        "placeholder-api" to "text-placeholder-api",
    )

    /** Returns the Modrinth slug for a given CurseForge slug, or the original if not found. */
    fun getMrSlug(cfSlug: String): String = table.entries.find { it.value == cfSlug }?.key ?: cfSlug

    /** Returns the CurseForge slug for a given Modrinth slug, or the original if not found. */
    fun getCfSlug(mrSlug: String): String = table[mrSlug] ?: mrSlug
}