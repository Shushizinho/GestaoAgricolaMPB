ProcessadorDeDados: main.o receive.o insert.o median.o serialize.o extract.o enqueue.o mov_vec.o
	gcc main.o receive.o insert.o median.o serialize.o extract.o enqueue.o mov_vec.o -z noexecstack -o ProcessadorDeDados
	
main.o: main.c
	gcc -g -Wall -Wextra -fanalyzer -c main.c -o main.o
	
receive.o: receive.c 
	gcc -g -Wall -Wextra -fanalyzer -c receive.c -o receive.o 
	
insert.o: insert.c 
	gcc -g -Wall -Wextra -fanalyzer -c insert.c -o insert.o 
	
median.o: median.s
	gcc -g -Wall -Wextra -fanalyzer -c median.s -o median.o
	
serialize.o: serialize.c 
	gcc -g -Wall -Wextra -fanalyzer -c serialize.c -o serialize.o 
	
extract.o: extract.s
	gcc -g -Wall -Wextra -fanalyzer -c extract.s -o extract.o

enqueue.o: enqueue.s
	gcc -g -Wall -Wextra -fanalyzer -c enqueue.s -o enqueue.o
	
mov_vec.o: mov_vec.s
	gcc -g -Wall -Wextra -fanalyzer -c mov_vec.s -o mov_vec.o

run: ProcessadorDeDados
	./ProcessadorDeDados
		
clean:
	rm ∗.o ProcessadorDeDados
