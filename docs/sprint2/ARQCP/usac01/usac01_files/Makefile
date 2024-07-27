main: extract.o main.o
	gcc extract.o main.o -o main
	
extract.o: extract.s
	gcc -g -Wall -Wextra -fanalyzer -c extract.s -o extract.o

main.o: main.c
	gcc -g -Wall -Wextra -fanalyzer -c main.c -o main.o

run: main
	./main
	rm -f *.o main

clean: 
	rm -f *.o main

