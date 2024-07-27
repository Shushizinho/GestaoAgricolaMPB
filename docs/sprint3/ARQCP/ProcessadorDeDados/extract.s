.section .data
.section .text

.global extract_token

extract_token:
	movl $0, %r9d
    call search_word               # Chama a função de busca
    cmpq $0, %rax
    je not_found


not_found:
    ret

search_word:
    movq $0, %rax                  # Zera %rax (resultado: ponteiro para a palavra encontrada)
    movq $0, %r8                   # Zera %r8 (índice na palavra a ser procurada)
    movq $0, %rcx                  # Zera %rcx (índice na string de entrada)

search_loop:
    cmpb $0, (%rdi, %rcx)          # Compara o caractere atual com o terminador nulo
    je end_search                  # Se for o terminador nulo, termina a busca

    movb (%rdi, %rcx), %al         # Move o caractere atual para %al
    cmpb (%rsi, %r8), %al          # Compara o caractere atual com o caractere correspondente na palavra

    je match_characters            # Se os caracteres coincidirem, vá para match_characters

    # Os caracteres não coincidem, reinicia a busca
    movq $0, %r8                   # Reinicia o índice na palavra
    incq %rcx                      # Avança para o próximo caractere na string
    jmp search_loop

match_characters:
    incq %r8                       # Avança para o próximo caractere na palavra
    cmpb $0, (%rsi, %r8)           # Compara o próximo caractere na palavra com o terminador nulo

    je word_found                  # Se for o terminador nulo, a palavra foi encontrada

    incq %rcx                      # Avança para o próximo caractere na string
    jmp search_loop

word_found:
    addq $1, %rcx # Começar no asseguir aos ':'
    jmp loop_values
    
loop_values:
	
	cmpb $0,(%rdi, %rcx)
	je end_values
	
	cmpb $'#',(%rdi, %rcx)
	je end_values
	
	cmpb $'.',(%rdi, %rcx)
	je point
	
	cmpb $'0',(%rdi, %rcx)
	jb end_search

	cmpb $'9',(%rdi, %rcx)
	ja end_search
    
    
    movb (%rdi, %rcx), %al         # Move o caractere atual para %al
	subb $'0', %al                 # Subtrai o valor ASCII de '0'
    movzbl %al, %eax               # Estende o caractere para 32 bits
    
    imull $10, %r9d                # Multiplica o conteúdo de %r9d por 10
    addl %eax, %r9d
        
    incq %rcx
    jmp loop_values 
    
point:
	incq %rcx	
	jmp loop_values

great:
	incl %r9d
	jmp end_values
	
end_values:
	
	movl %r9d, (%rdx)
	movq $1, %rax
	ret

end_search:
	movq $0, %rax
    ret
