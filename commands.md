javac -Xlint:unchecked -d out (Get-ChildItem -Recurse src/main/java -Filter *.java)
jar cfe app.jar org.app.Main -C out .

``` sh
$ jpackage 
   --name MeuApp \ 
   --input . 
   --main-jar app.jar 
   --main-class com.exemplo.Main 
   --type deb 
   --app-version 1.0.0 
   --vendor "Minha Empresa"
```

``` bash
$ jpackage `
   --name MeuApp `
   --input . `
   --main-jar app.jar `
   --main-class com.exemplo.Main `
   --type exe `
   --app-version 1.0.0 `
   --vendor "Minha Empresa" `
   --win-menu `
   --win-shortcut
```

``` bash
jpackage `
   --name MeuApp `
   --input . `
   --main-jar app.jar `
   --main-class com.exemplo.Main `
   --type msi `
   --app-version 1.0.0 `
   --vendor "Minha Empresa" `
   --win-menu `
   --win-shortcut
```


-- --icon icon.ico