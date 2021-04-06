package br.com.zup.keymanagerrest.controller

import br.com.zup.CadastrarChavePixServiceGrpc
import br.com.zup.RemoverChavePixRequest
import br.com.zup.RemoverChavePixServiceGrpc
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.validation.Validated
import java.util.*
import javax.inject.Inject

@Validated
@Controller("/api/v1/clientes/{idCliente}")
class RemoverChavePixController {

    @Inject
    lateinit var removerChavePixClient:
            RemoverChavePixServiceGrpc.RemoverChavePixServiceBlockingStub

    @Delete("/pix/{idChavePix}")
    fun removerChavePix(idCliente: UUID, idChavePix: UUID) : HttpResponse<Any> {
        removerChavePixClient.remover(RemoverChavePixRequest.newBuilder()
            .setIdCliente(idCliente.toString())
            .setIdChavePix(idChavePix.toString())
            .build())

        return HttpResponse.ok()
    }

}