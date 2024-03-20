# Managing Projects

On this page, you will learn how to:

- [Add projects](#adding-projects)
- [Remove projects](#removing-projects)
- [Update projects](#updating-projects)

## Adding Projects

To add a project, run the [`pakku add`](pakku-add.md) command:

<include from="pakku-add.md" element-id="snippet-cmd"/>

The `<projects>...` argument accepts only the project slug or ID 
and allows multiple projects to be added.

Examples:

```
%pakku% add jei
%pakku% add 238222
%pakku% add jei terrafirmacraft
```

## Removing Projects

To remove a project, run the [`pakku rm`](pakku-rm.md) command:

<include from="pakku-rm.md" element-id="snippet-cmd"/>

The `[<projects>...]` argument accepts only the project slug, name or ID
and allows multiple projects to be removed.

```
%pakku% rm jei
%pakku% rm "Just Enough Items"
%pakku% rm 238222
%pakku% rm jei terrafirmacraft
```

To remove all project from the modpack, use the `--all` flag:

```
%pakku% rm --all
```

<warning>
Warning: This is a dangerous operation and therefore
you will be asked whether you really want to proceed.
</warning>

## Updating Projects

To update a project, run the [`pakku update`](pakku-update.md) command:

<include from="pakku-update.md" element-id="snippet-cmd"/>

The `[<projects>...]` argument accepts only the project slug, name or ID
and allows multiple projects to be updated.

```
%pakku% update jei
%pakku% update "Just Enough Items"
%pakku% update 238222
%pakku% update jei terrafirmacraft
```

To update all project in the modpack, use the `--all` flag:

```
%pakku% update --all
```