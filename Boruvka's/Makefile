JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Main.java 

default: classes
	chmod +x hw5

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class