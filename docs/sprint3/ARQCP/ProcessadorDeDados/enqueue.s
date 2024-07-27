.section .text
    .global enqueue_value


enqueue_value:
    cmp $0, %rsi
    je end
    movl (%rcx), %r9d
    mov %r8d,(%rdi, %r9, 4) #move o value para *array[write]
    incl (%rcx) #incrementa write
    cmpl (%rcx), %esi #compara write com length
    jne not_max_write #se nao forem iguais salta
    movl $0, (%rcx) #se forem coloca a zero
not_max_write:
    mov (%rcx), %r9d
    cmpl %r9d, (%rdx) #compara aux com read
    jne end #se nao forem iguais salta
    incl (%rdx) #se forem incrementa read
    cmpl (%rdx), %esi #compara read com length
    jne end #se nao forem iguais salta
    movl $0, (%rdx) #se forem coloca a zero
end:
    ret
