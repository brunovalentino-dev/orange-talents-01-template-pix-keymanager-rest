package br.com.zup.keymanagerrest.controller

import br.com.zup.BuscarChavePixRequest
import br.com.zup.BuscarChavePixServiceGrpc
import br.com.zup.keymanagerrest.response.ChavePixDetalheResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.validation.Validated
import java.util.*
import javax.inject.Inject

@Validated
@Controller("/api/v1/clientes/{idCliente}")
class BuscarChavePixController {

    @Inject
    lateinit var buscarChavePixClient:
            BuscarChavePixServiceGrpc.BuscarChavePixServiceBlockingStub

    @Get("/pix/{idChavePix}")
    fun buscarChavePix(idCliente: UUID, idChavePix: UUID) : HttpResponse<Any> {
        val response = buscarChavePixClient.buscar(BuscarChavePixRequest.newBuilder()
            .setFiltroId(
                BuscarChavePixRequest.FiltroId.newBuilder()
                    .setIdCliente(idCliente.toString())
                    .setIdChavePix(idChavePix.toString())
                    .build()
            )
            .build()
        )

        return HttpResponse.ok(ChavePixDetalheResponse(response))
    }

}