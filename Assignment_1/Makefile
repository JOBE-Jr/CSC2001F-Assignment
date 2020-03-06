JAVAC = /usr/bin/javac
.SUFFIXES: .java .class

SRCDIR = src
BINDIR = bin
DATADIR = data

$(BINDIR)/%.class:%$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES = LoadShedding.class FileData.class LSArray.class LSArrayApp.class LSBST.class LSBSTApp.class \
BinaryTree.class BInarySearchTree.class BTQueue.class BTQueueNode.class BinaryTreeNode.class BinaryTreeNode.class

CLASS_FILES = $(CLASSES:%.class = $(BINDIR)/%.class)
default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class
	rm $(SRCDIR)/*~
	rm $(DATADIR)/*

runA:
	java -cp bin LSArrayApp $(stage) $(day) $(time)

runB:
	java -cp bin LSBSTApp $(stage) $(day) $(time)