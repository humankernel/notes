##  Developer Productivity

know your tools:
- diff / fc : file comparison 
- sum : generate checksum to monitor modifications

Customize your shell: (bash native, minimal/portable setup)
alias, autocompletion



### Editor Fluency

When editing text, move and make selections by 
- [x] character  (`v+hjkl`)
- [x] word  (`vw`  | `vb` )
- [x] line  (`V`)
- [x] paragraph  (`vip` select inside paragraph)

When editing code, move by various syntactic units (
- [ ] matching delimiters, 
- [ ] functions, 
- [ ] modules, …)

- [x] Reindent code following changes.
- [x] Comment and uncomment blocks of code with a single command. 
- [x] Undo and redo changes.
- [x] Split the editor window into multiple panels, and navigate between them.
- [ ] Navigate to a particular line number. 
- [ ] Sort selected lines.
- [ ] Search for both strings and regular expressions, and repeat previous searches.
- [ ] Temporarily create multiple cursors based on a selection or on a pattern match, and edit the text at each in parallel.
- [ ] Display compilation errors in the current project. 
- [ ] Run the current project’s tests
- [ ] Debug
- [ ] Vim Macros
- [ ] Advanced Git integration
- [ ] Advanced Undo


### Version Control
A Thought Experiment
Spill an entire cup of tea (English breakfast, with a little milk) onto your laptop keyboard. Take the machine to the smart-person bar, and have them tut and frown. Buy a new computer. Take it home.

How long would it take to get that machine back to the same state it was in (with all the SSH keys, editor configuration, shell setup, installed applications, and so on) at the point where you first lifted that fateful cup? This was an issue one of us faced recently.

Just about everything that defined the configuration and usage of the original machine was stored in version control, including:
- All the user preferences and dotfiles 
- The editor configuration
- The list of software installed using Homebrew 
- The Ansible script used to configure apps 
- All current projects

The machine was restored by the end of the afternoon



- [ ] how to roll back
- [ ] 