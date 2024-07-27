.section .text
    .global mediana


mediana:
    push %rax
    push %rsi
    push %rdi
    call sort_array
    pop %rdi
    pop %rsi
    pop %rax
    mov %esi, %eax
    cdq
    cmp $0, %esi
    je end_med
    mov $2, %ecx
    idiv %ecx
    mov (%rdi,%rax,4), %eax
    movslq %eax, %rax
end_med:
    ret
sort_array:
    loop:
        cmpl $0, %esi #compara o valor armazenado em esi com 0
        je end #se o valor armazenado em esi for igual a 0, salta para end

        movq %rdi, %r9 #coloca o valor em rdi em r9, rdi é automaticamente o valor de ptr recebido na função em c, sendo este o primeiro parametro
        movl %esi, %ecx #coloca o valor em esi em ecx,  é automaticamente o valor de num recebido na função em c,
    #sendo este o segundo parametro e sendo este um int

        continue:
            decl %ecx #decrementa 1 ao valor armazenado em ecx
            cmpl $0, %ecx #compara o valor em ecx com 0
            je complete #se o valor em ecx for igual a 0, salta para complete

            addq $4, %r9 #adiciona 4 ao valor armazenado em r9, para mover para o próximo elemento do vetor

			movl $0, %edx #coloca o valor em edx a 0
            movl $0, %eax #coloca o valor em eax a 0

            movl (%r9), %edx #coloca o valor em r9 em edx
            movl (%rdi), %eax #coloca o valor em rdi em eax

            cmpl %edx, %eax #compara o valor em eax com o valor em edx
            jle continue #se o valor em eax for menor ou igual ao valore em edx

            movl %edx, (%rdi) #coloca o valor em edx no endereço apontado por rdi
            movl %eax, (%r9) #coloca o valor em eax,no endereço apontado por r9

            jmp continue #salta para continue

        complete:
            addq $4, %rdi #adiciona 4 ao valor armazenado em rdi, para mover para o próximo elemento do vetor
            decl %esi #decrementa 1 ao valor armazenado em esi

    jmp loop #salta para loop

end:
	movl %esi, %eax #coloca o valor de esi em eax
    ret #retorna o valor armazenado em eax
