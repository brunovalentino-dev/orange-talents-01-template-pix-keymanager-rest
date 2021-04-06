package br.com.zup.keymanagerrest.controller

import br.com.zup.CadastrarChavePixServiceGrpc
import br.com.zup.keymanagerrest.request.CadastrarRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import java.util.*
import javax.inject.Inject
import javax.validation.Valid

@Validated
@Controller("/api/v1/clientes/{idCliente}")
class CadastrarChavePixController {

    @Inject
    lateinit var cadastrarChavePixClient:
            CadastrarChavePixServiceGrpc.CadastrarChavePixServiceBlockingStub

    @Post("/pix")
    fun cadastrarChavePix(idCliente: UUID, @Valid @Body request: CadastrarRequest) :
            HttpResponse<Any> {
        val response = cadastrarChavePixClient.cadastrar(request.toGRPCModel(idCliente))

        val uri = HttpResponse.uri("/api/v1/clientes/${idCliente.toString()}/pix/${response.idChavePix}")

        return HttpResponse.created(uri)
    }

}