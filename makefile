ATM.class: ATM.java
	javac -g ATM.java
clean:
	rm *.class
run: ATM.class
	java ATM
