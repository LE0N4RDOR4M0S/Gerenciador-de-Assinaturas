package com.leonardoramos.assinaturas.auditoria;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AuditoriaListener {

    private static ApplicationContext context;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        AuditoriaListener.context = applicationContext;
    }

    @PrePersist
    public void auditarCriacao(Object entity) {
        auditar(entity, "CREATE");
    }

    @PreUpdate
    public void auditarAtualizacao(Object entity) {
        auditar(entity, "UPDATE");
    }

    @PreRemove
    public void auditarRemocao(Object entity) {
        auditar(entity, "DELETE");
    }

    public void auditar(Object entity, String operacao) {
        AuditoriaService auditoriaService = context.getBean(AuditoriaService.class);

        LogAuditoria log = new LogAuditoria();
        log.setEntidade(entity.getClass().getSimpleName());
        log.setOperacao(operacao);
        log.setDataHora(LocalDateTime.now());
        log.setUsuario("admin"); //TODO: Implementar a obtenção do usuário autenticado

        auditoriaService.salvarLog(log);
    }

//TODO: Implementar a obtenção do usuário autenticado
/*
//    private String getUsuarioAutenticado() {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            return ((UserDetails) principal).getUsername();
//        }
//        return "Desconhecido";
//    }
 */
}
