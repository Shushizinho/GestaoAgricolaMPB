prog_pointer: main.o
	gcc main.o -o prog_pointer

main.o: main.c
	gcc -g -Wall -Wextra -fanalyzer -c main.c -o main.o

clean:
	rm -f *.o prog_pointer

run: prog_pointer
	./prog_pointer