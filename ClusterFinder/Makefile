##Makefile to compile
##Zach Nudelman
##29 March 2017

LIB = ../lib
SRCDIR = src
BINDIR = bin
TESTDIR = test
DOCDIR = doc
CLI = $(LIB)/cli/commons-cli-1.3.1.jar
ASM = $(LIB)/asm/asm-5.0.4.jar:$(LIB)/asm/asm-commons-5.0.4.jar:$(LIB)/asm/asm-tree-5.0.4.jar
JUNIT = $(LIB)/junit/junit-4.12.jar:$(LIB)/junit/hamcrest-core-1.3.jar
JACOCO = $(LIB)/jacoco/org.jacoco.core-0.7.5.201505241946.jar:$(LIB)/jacoco/org.jacoco.report-0.7.5.201505241946.jar:
TOOLS = $(LIB)/tools
JAVAC = /usr/bin/javac
JFLAGS = -g -d $(BINDIR) $(SRCDIR)/*.java -cp $(BINDIR)

vpath %.java $(SRCDIR):$(TESTDIR)
vpath %.class $(BINDIR)
vpath %.exec coverage

# define general build rule for java sources
.SUFFIXES:  .java  .class

.java.class:
	$(JAVAC)  $(JFLAGS)  $<

#default rule - will be invoked by make
all: ClusterFinder.class \
				ExtractFeatures.class \
				Bin.class \
				BinList.class \
				Discretizer.class \
				Counter.class \
				ModeExtractor.class


# Rule for generating documentation
doc:
	javadoc -d $(DOCDIR) $(SRCDIR)/*.java

test_classes:	all

#Rule for unit tests
test:
	java -ea -cp $(BINDIR):$(JUNIT) org.junit.runner.JUnitCore TestSuite

# Rules for generating tests
jacoco.exec: test_classes
	java -ea -javaagent:$(LIB)/jacoco/jacocoagent.jar -cp $(BINDIR):$(JUNIT) org.junit.runner.JUnitCore TestSuite

report: jacoco.exec
	java -cp $(BINDIR):$(CLI):$(JACOCO):$(ASM):$(TOOLS) Report --reporttype html .

cluster: all
	java -cp $(BINDIR) ClusterFinder $(ARGS)

cluster1: all
	java -cp $(BINDIR) ClusterFinder 2014 1 1

extract1: all
	java -cp $(BINDIR) ExtractFeatures 2014clusterCount1Modal.csv 6 0 1 4 5 7 9

bin1: all
	java -cp $(BINDIR) Discretizer 2014clusterCount1ModalSelected.csv 2 income.txt floorArea.txt

mode1: all
	java -cp $(BINDIR) ModeExtractor 2014clusterCount1.csv Municipality

all1: cluster1 mode1 extract1 bin1




#Cleans folders
clean:
	@rm -f  $(BINDIR)/*.class
	@rm -f jacoco.exec *.xml *.csv
	@rm -Rf coveragereport
