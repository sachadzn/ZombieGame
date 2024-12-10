# Par défaut, la cible est de compiler cls doc et les jar
default: zombicide.jar doc cls

# Nettoyer les fichiers générés
clean:
	rm -rf classes/*.class docs/ jar/*

# Générer la javadoc
doc:
	javadoc -cp junit-console.jar:src:test -d docs src/*.java src/*/*.java test/*.java test/*/*.java

# Créer le jar
zombicide.jar: cls
	mkdir -p jar
	jar cvfe jar/zombicide.jar GameMain -C classes .

# Compiler les fichiers .class
cls:
	javac -sourcepath src -d classes src/**/*.java src/*.java
