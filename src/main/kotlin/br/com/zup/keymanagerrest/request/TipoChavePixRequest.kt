package br.com.zup.keymanagerrest.request

import br.com.zup.TipoChavePix
import io.micronaut.validation.validator.constraints.EmailValidator

enum class TipoChavePixRequest (val request: TipoChavePix) {

    CPF(TipoChavePix.CPF) {
        override fun validar(chavePix: String?): Boolean {
            if (chavePix.isNullOrBlank()) {
                return false
            }
            else if (!chavePix.matches("^[0-9]{11}$".toRegex())) {
                return false
            }

            return true
        }
    },
    NUMERO_CELULAR(TipoChavePix.NUMERO_CELULAR) {
        override fun validar(chavePix: String?): Boolean {
            if (chavePix.isNullOrBlank()) {
                return false
            }
            else if (!chavePix.matches("^\\+[1-9][0-9]\\d{1,14}\$".toRegex())) {
                return false
            }

            return true
        }
    },
    EMAIL(TipoChavePix.EMAIL) {
        override fun validar(chavePix: String?): Boolean {
            if (chavePix.isNullOrBlank()) {
                return false
            }
            return EmailValidator().run {
                initialize(null)
                isValid(chavePix, null)
            }
        }
    },
    CHAVE_ALEATORIA(TipoChavePix.CHAVE_ALEATORIA) {
        override fun validar(chavePix: String?): Boolean {
            if (chavePix.isNullOrBlank()) {
                return true
            }

            return false
        }
    };

    abstract fun validar(chavePix: String?): Boolean

}
