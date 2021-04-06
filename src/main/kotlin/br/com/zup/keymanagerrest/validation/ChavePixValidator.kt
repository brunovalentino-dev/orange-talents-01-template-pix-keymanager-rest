package br.com.zup.keymanagerrest.validation

import br.com.zup.keymanagerrest.request.CadastrarRequest
import javax.inject.Singleton
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

@Singleton
class ChavePixValidator : ConstraintValidator<ChavePixValida, CadastrarRequest> {

    override fun isValid(value: CadastrarRequest?, context: ConstraintValidatorContext?): Boolean {
        if (value?.tipoChavePix == null) {
            return false
        }

        return value.tipoChavePix.validar(value.chavePix)
    }

}
