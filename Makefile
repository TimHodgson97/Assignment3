# Makefile for cloud analysis parallel assignment

JAVAC=/usr/bin/javac

.SUFFIXES: .java .class

.java.class:
	$(JAVAC) $<

classes: Meteorology.class SerialCloud.class \
         CloudData.class ThreadSum.class \
         Vector.class

default: $(CLASSES)

clean:
	rm *.class
