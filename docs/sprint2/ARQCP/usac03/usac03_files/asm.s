.section .text
    .global move_num_vec    

							# array in rdi
							# length in rsi
							# read in rdx
							# write in rcx
							# num in r8
							# vec in r9

move_num_vec:
	pushq %rbp           	# Save the base pointer
    movq %rsp, %rbp
    
    movq (%rdx), %rax 	 	# coloca o valor que está em read em rax
    pushq %rax			 	# dá push ao rax
	cmpq %rsi, %r8 		 	# verificar se o tamanho é suficiente para copiar
	jg end_size_not_enough  # se num for maior que length entra em end_size_not_enough
	subl $1, %esi		 	# subtrai 1 ao valor em length
	movl (%rcx), %r10d	 	# coloca o valor de write em aux
	movq $0, %rax		 	# coloca 0 em rax
	
not_full:
	cmpl (%rdx), %r10d 		# compara read com write
	je equal_read_write		# se forem iguais entra na função equal_read_write
	cmpl (%rdx), %esi 		# compara read com o fim do array
	je end_of_array2		# se forem iguais entra na função end_of_array2
	addl $1, (%rdx)			# adiciona 1 ao valor do read
	
continue2:
	incq %rax 				# contar o numero de valores do read ao write para ver se há números suficientes para copiar
	jmp not_full
	
equal_read_write:
	cmpq %rax, %r8 			# compara o distância entre o read e o write com o numero a copiar
	jg end_size_not_enough  # se for maior não ha numeros suficientes no buffer
	popq %rax
	movq %rax, (%rdx)		# coloca o valor de rax no read
	jmp copy_data
	
copy_data:
	movslq (%rdx), %r10		# coloca o valor de read em aux
	movl (%rdi, %r10, 4), %eax # coloca o valor de array[read] em eax
	movl %eax, (%r9) 		# copia o valor para vec
	cmpq $1, %r8   			# compara o valor de num com 1
	je end					# se forem iguais entra na função end
	cmpl (%rdx), %esi 		# verificar se o read chegou ao fim do vetor
	je end_of_array 		# se chegou, entra na função end_of_array
	addl $1, (%rdx)			# adiciona 1 a read 
	
continue:
	addq $4, %r9
	decq %r8				# decrementa o num
	jmp copy_data
	
end_of_array:
	movl $0, (%rdx) 		# coloca reader a apontar para o inicio do array
	jmp continue 			# volta para continue
	
end_of_array2:
	movl $0, (%rdx) 		# coloca reader a apontar para o inicio do array
	jmp continue2 			# volta para continue2
	
end:
	movl $1, %eax
	addl $1, (%rdx)
	movq %rbp, %rsp      	# restaura o pointer da stack para o pointer base 
    popq %rbp 				# restaura o %rbp
	ret
end_size_not_enough:
	movl $0, %eax
	movq %rbp, %rsp      	# restaura o pointer da stack para o pointer base 
    popq %rbp 				# restaura o %rbp
	ret






