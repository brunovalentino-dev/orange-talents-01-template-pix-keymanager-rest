package br.com.zup.keymanagerrest.request

import br.com.zup.CadastrarChavePixRequest
import br.com.zup.TipoChavePix
import br.com.zup.TipoConta
import br.com.zup.keymanagerrest.validation.ChavePixValida
import io.micronaut.core.annotation.Introspected
import java.util.*

@ChavePixValida
@Introspected
class CadastrarRequest (
    val tipoConta: TipoContaRequest?,
    val chavePix: String?,
    val tipoChavePix: TipoChavePixRequest?
)
{
    fun toGRPCModel(idCliente: UUID): CadastrarChavePixRequest {
        return CadastrarChavePixRequest.newBuilder()
            .setIdCliente(idCliente.toString())
            .setTipoConta(tipoConta?.request ?: TipoConta.CONTA_DESCONHECIDA)
            .setTipoChavePix(tipoChavePix?.request ?: TipoChavePix.CHAVE_DESCONHECIDA)
            .setChavePix(chavePix ?: "")
            .build()
    }
}
