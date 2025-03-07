package com.leonardoramos.assinaturas.auditoria;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditoriaService {

        private final LogAuditoriaRepository logAuditoriaRepository;

        public AuditoriaService(LogAuditoriaRepository logAuditoriaRepository) {
            this.logAuditoriaRepository = logAuditoriaRepository;
        }

        @Transactional
        public void salvarLog(LogAuditoria logAuditoria) {
            logAuditoriaRepository.save(logAuditoria);
        }
}
