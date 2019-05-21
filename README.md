# list

Reads ".ignore" file from work directory and recursively listing all besides the ones listed in that file.

Compilation (from project root directory) :

```bash
javac -d . src/com/test/*.java
jar cfm list.jar src/META-INF/MANIFEST.MF  com/test/*.class
```
