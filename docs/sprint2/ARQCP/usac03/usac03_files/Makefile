main: asm.o main.o
	gcc asm.o main.o -o main

asm.o: asm.s
	gcc -g -Wall -Wextra -fanalyzer -c asm.s -o asm.o

main.o: main.c
	gcc -g -Wall -Wextra -fanalyzer -c main.c -o main.o

run: main
	./main
	rm -f *.o main

clean: 
	rm -f *.o main

