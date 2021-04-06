package br.com.zup.keymanagerrest.response

import br.com.zup.ListarChavePixResponse
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

class ChavePixResponse (chavePixData: ListarChavePixResponse.ChavePix) {
    val id = chavePixData.idChavePix
    val chavePix = chavePixData.chavePix
    val tipoChavePix = chavePixData.tipoChavePix
    val tipoConta = chavePixData.tipoConta
    val criadaEm = chavePixData.criadaEm.let {
        LocalDateTime.ofInstant(Instant.ofEpochSecond(it.seconds, it.nanos.toLong()),
            ZoneId.of("UTC"))
    }
}