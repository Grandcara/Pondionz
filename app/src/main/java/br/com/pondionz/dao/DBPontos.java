package br.com.pondionz.dao;

import android.content.ContentValues;

import com.google.android.gms.maps.model.LatLng;

import java.util.LinkedList;
import java.util.List;

import br.com.pondionz.model.Ponto;

/**
 * Created by Iago on 09/03/2016.
 */
class DBPontos {
    private static List<ContentValues> insertValues = new LinkedList<ContentValues>();
    public static List<ContentValues> getPontos(){
        getSJDR();
        getDivi();
        return insertValues;
    }
    private static void getSJDR() {
        //Br sentido bengo
        insertValues.add(values(new Ponto(1,1,new LatLng(-21.103340, -44.249926), "CTAN", "Ponto dentro da UFSJ (campus CTAN), perto do prédio da musica","xy"))); //id 1
// linha 15
        insertValues.add(values(new Ponto(2,1,new LatLng(-21.111300, -44.243445), "BAR ÚLTIMO GOLO", "Ponto em frente ao motel planeta sex","x"))); //id 2
// linha 6 e 15
//leite castro
//Sentido centro
        insertValues.add(values(new Ponto(3,1,new LatLng(-21.114210, -44.244101), "AQUARIUS", "Primeiro ponto na Leite de Castro sentido centro","y"))); //id 3
// linhas 3, 4, 5, 6, 14, 15, 17
        insertValues.add(values(new Ponto(4,1,new LatLng(-21.117548, -44.245300), "DIMARE", "Ponto em frente a APAE, do outro lado da avenida","y"))); //id 4
// linhas 3, 4, 5, 6, 14, 15, 17
        insertValues.add(values(new Ponto(5,1,new LatLng(-21.118782, -44.245759), "CEMITÉRIO", "Ponto do cemitério municipal (Quicumbi)","y"))); //id 5
// linhas 3, 4, 5, 6, 14, 15, 17
        insertValues.add(values(new Ponto(6,1,new LatLng(-21.120971, -44.246573), "IPTAN", "Ponto em frente a faculdade IPTAN","y"))); //id 6
// linhas 3, 4, 5, 6, 14, 15, 17
        insertValues.add(values(new Ponto(7,1,new LatLng(-21.123042, -44.247478), "CASA DE PASTORAL", "Ponto em frente a diocese","y"))); //id 7
// linhas 3, 4, 5, 6, 14, 15, 17
        insertValues.add(values(new Ponto(8,1,new LatLng(-21.125484, -44.248652), "SEMÁFORO", "Ponto depois do semáforo da Leite de Castro (no pé do morro do dom Bosco)","y"))); //id 8
// linhas 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 18, 22
        insertValues.add(values(new Ponto(9,1,new LatLng(-21.129480, -44.250626), "FIAÇÃO E TECELAGEM", "Final da Leite de Castro","y"))); //id 9
// linhas 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 18, 22
        insertValues.add(values(new Ponto(10,1,new LatLng(-21.130793, -44.253470), "IGREJA PRESBITERIANA", "Ponto da Rua Paulo Freitas (enfrente a Auto Escola Del Rei)","y"))); //id 10
// linhas 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 18, 22
        insertValues.add(values(new Ponto(11,1,new LatLng(-21.132880, -44.258162), "RODOVIÁRIA VELHA (NOTURNO)", "Ponto em frente a sorveteria Gelapapo (ônibus param aqui a partir das 19h)","y"))); //id 11
// linhas 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 18, 22
//Sentido COLONIA
        insertValues.add(values(new Ponto(12,1,new LatLng(-21.113686, -44.243712), "GERALDINHO LANCHES", "Ponto no final da Leite de Castro (Sentido colônia)","x"))); //id 12
// linhas 3, 4, 5, 6, 15, 17
        insertValues.add(values(new Ponto(13,1,new LatLng(-21.1151975, -44.2442834), "GÁS2IRMÃOS", "Ponto próximo ao posto Vianini","x"))); //id 13
// linhas 3, 4, 5, 6, 15, 17
        insertValues.add(values(new Ponto(14,1,new LatLng(-21.1176486, -44.2451419), "APAE", "Ponto próximo ao DELFOR Motors","x"))); //id 14
// linhas 3, 4, 5, 6, 15, 17
        insertValues.add(values(new Ponto(15,1,new LatLng(-21.119320, -44.245687), "POLICIA CIVIL", "Ponto próximo ao supermercado Bahamas","x"))); //id 15
// linhas 3, 4, 5, 6, 15, 17
        insertValues.add(values(new Ponto(16,1,new LatLng(-21.121207, -44.246331), "TURCAN LANCHES", "Ponto em frente ao IPTAN","x"))); //id 16
// linhas 3, 4, 5, 6, 15, 17
        insertValues.add(values(new Ponto(17,1,new LatLng(-21.1230693, -44.2472506), "PADARIA S&N", "Ponto em frente a Casa Paroquial, do outro lado da avenida","x"))); //id 17
// linhas 3, 4, 5, 6, 15, 17
        insertValues.add(values(new Ponto(18,1,new LatLng(-21.1243538, -44.247886), "CALCINFER", "Ponto em frente a CACEL, do outro lado da avenida","x"))); //id 18
// linhas 3, 4, 5, 6, 15, 17
        insertValues.add(values(new Ponto(19,1,new LatLng(-21.127805, -44.2495636), "PANIFICADORA SÃO GERALDO", "Ponto em frente ao supermercado Sales, do outro lado da avenida","x"))); //id 19
// linhas 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 18, 22
        insertValues.add(values(new Ponto(20,1,new LatLng(-21.1293755, -44.2503266), "BLACK BELT", "Ponto em frente à escola Aureliano Pimentel, do outro lado da avenida","x"))); //id 20
// linhas 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 18, 22
//rua da estação sentido leite castro
        insertValues.add(values(new Ponto(21,1,new LatLng(-21.1318539, -44.2540105), "PERTO DA ESTAÇÃO", "Ponto próximo a loja Requinte","x"))); //id 21
// linhas 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 18, 22
        insertValues.add(values(new Ponto(22,1,new LatLng(-21.1329501, -44.2571819), "ESTAÇÃO", "Ponto próximo à praça estação, em frente a estação ferroviária","x"))); //id 22
// linhas 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 18, 22
//rua tiradentes
        insertValues.add(values(new Ponto(23,1,new LatLng(-21.135166, -44.2578671), "CINEMA", "Ponto próximo a Santa Casa","y"))); //id 23
// linhas 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 18, 22
        insertValues.add(values(new Ponto(24,1,new LatLng(-21.1371282, -44.2605692), "JOÃO DOS SANTOS", "Ponto atrás da escola João dos Santos e em frente a Cultura Inglesa II","y"))); //id 24
// linhas 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 18, 22
//tejuco
        insertValues.add(values(new Ponto(25,1,new LatLng(-21.1383253, -44.263937), "BIQUINHA", "Ponto próximo ao bar Tia Maria II","x"))); //id 25
// linhas 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 18, 22
        insertValues.add(values(new Ponto(26,1,new LatLng(-21.1389347, -44.2660399), "MINAS FUTEBOL CLUB", "Ponto próximo à academia Physical","x"))); //id 26
// linhas 1, 2, 3, 4, 5, 6, 7, 8, 9, 14, 17, 18
// rua Dr. balbino da cunha
        insertValues.add(values(new Ponto(27,1,new LatLng(-21.1383222, -44.2608139), "SÃO FRANCISCO", "Ponto próximo à UFSJ (campus Santo Antônio)","x"))); //id 27
// linhas 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 18, 22
        insertValues.add(values(new Ponto(28,1,new LatLng(-21.136035, -44.257388), "COLÉGIO N. SRA. DAS DORES", "Ponto em frente à Santa Casa da Misericórdia","x"))); //id 28
// linhas 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 18, 22
//Rodoviarias (tanto a antiga como a nova)
        insertValues.add(values(new Ponto(29,1,new LatLng(-21.1263728, -44.2466112), "RODOVIÁRIA NOVA - FRENTE", "Ponto em frente à rodoviária nova","x"))); //id 29
// linhas 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 18, 22
        insertValues.add(values(new Ponto(30,1,new LatLng(-21.1269549, -44.2474169), "RODOVIÁRIA NOVA - ESQUERDA", "Ponto do lado esquerdo da rodoviária nova, perto do bar do bigode","x"))); //id 30
        insertValues.add(values(new Ponto(31,1,new LatLng(-21.125911, -44.246552), "RODOVIÁRIA - DIREITA", "Ponto do lado direito da rodoviária nova, perto da loja Luck’s","y"))); //id 31
//PS: coloca rodoviária ou a loja como título? Ponto é exatamente em frente a loja
// linhas 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 18, 22
        insertValues.add(values(new Ponto(32,1,new LatLng(-21.127894, -44.246405), "DIVINA GULA", "Ponto próximo da lanchonete Divina Gula","x"))); //id 32
        insertValues.add(values(new Ponto(33,1,new LatLng(-21.1269567, -44.2446902), "JGM", "Ponto próximo a academia corpo livre","x"))); //id 33                    VERIFICAR
        insertValues.add(values(new Ponto(34,1,new LatLng(-21.1267887, -44.2444049), "INKPLUS", "Ponto próximo ao Ekip-Car","y"))); //id 34                    VERIFICAR (acho que o ponto foi um pouco pra frente, tenho que conferir pessoalmente)
        insertValues.add(values(new Ponto(35,1,new LatLng(-21.1264203, -44.2427251), "SENAI ESQUERDO", "Ponto próximo à danceteria Matozinhos","x"))); //id 35
        insertValues.add(values(new Ponto(36,1,new LatLng(-21.1272607, -44.2411627), "PARÓQUIA DE MATOZINHOS", "Ponto perto da praça da igreja do Bom Jesus de Matozinhos","x"))); //id 36
        insertValues.add(values(new Ponto(37,1,new LatLng(-21.127237, -44.241153), "BANCA DE MATOZINHOS", "Ponto em frente a banca de jornais da praça da igreja do Bom Jesus de Matozinhos","y"))); //id 37
        insertValues.add(values(new Ponto(38,1,new LatLng(-21.131439, -44.236202), "SÃO JOSÉ VEÍCULOS", "Ponto próximo à drogaria Luiza","x"))); //id 38
        insertValues.add(values(new Ponto(39,1,new LatLng(-21.1285848, -44.2395743), "E.E. TOME PORTES DEL REI", "Ponto em frente ao shopping das carnes matozinhos","x"))); //id 39
        insertValues.add(values(new Ponto(40,1,new LatLng(-21.1299405, -44.2379457), "JB MÁQUINAS", "Ponto em frente a antiga delegacia, do outro lado da avenida","x"))); //id 40                    VERIFICAR, todo mundo fala que lá era uma delegacia, mas irei confirmar a veracidade dessa informação
        insertValues.add(values(new Ponto(41,1,new LatLng(-21.1260984, -44.2423157), "SENAI DIREITO", "Ponto próximo ao atacadão da construção, sentido Leite Castro","y"))); //id 41
        insertValues.add(values(new Ponto(42,1,new LatLng(-21.126356, -44.240730), "LABORATÓRIO SANTA CRUZ", "Ponto ao lado da academia white tiger","y"))); //id 42                    VERIFICAR, não sei se essa academia ainda existe, vou conferir pessoalmente
        insertValues.add(values(new Ponto(43,1,new LatLng(-21.1264663, -44.2403443), "LATERAL DA IGREJA B. J. MATOZINHOS", "Ponto do lado da igreja de Bom Jesus de Matozinhos","x"))); //id 43
        insertValues.add(values(new Ponto(44,1,new LatLng(-21.1267266, -44.239047), "CLUBDVD", "Ponto proximo à loja Hering Básico Matozinhos","y"))); //id 44                    VERIFICAR, acho que a locadora fechou, tenho que ir lá conferir
        insertValues.add(values(new Ponto(45,1,new LatLng(-21.127013, -44.238184), "JEAN MODAS", "Ponto próximo ao Bergão Matozinhos","x"))); //id 45                    VERIFICAR
//rua av rei tome portes del rei
        insertValues.add(values(new Ponto(46,1,new LatLng(-21.1255297, -44.2371988), "INOCOOP", "Ponto próximo à panificadora Topo Frios, em frente à saída lateral do condomínio","x"))); //id 46
        insertValues.add(values(new Ponto(47,1,new LatLng(-21.125492, -44.237220), "PANIFICADORA TOPO FRIOS", "Ponto próximo à saída lateral do INOCOOP, em frente a panificadora Topo Frios","y"))); //id 47
// Adicionados depois
        insertValues.add(values(new Ponto(48,1,new LatLng(-21.132264, -44.258519), "RODOVIÁRIA VELHA (DIURNO)", "Ponto na rodoviária velha (ônibus param aqui até às 19h)","y"))); //id 48
// linhas 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 18, 22
        insertValues.add(values(new Ponto(49,1,new LatLng(-21.131467, -44.252055), "DIGITRON", "Ponto no final da rua Antônio Rocha","x"))); //id 49
// linhas 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 18, 22
        insertValues.add(values(new Ponto(50,1,new LatLng(-21.131334, -44.236227), "PONTO SEM IDENTIFICAÇÃO 1", "Ponto próximo à concessionária São José Veículos","y"))); //id 50                    VERIFICAR
        insertValues.add(values(new Ponto(51,1,new LatLng(-21.132625, -44.234788), "ANAPECC", "-","x"))); //id 51                    VERIFICAR
        insertValues.add(values(new Ponto(52,1,new LatLng(-21.132465, -44.234868), "PONTO SEM IDENTIFICAÇÃO 2", "-","y"))); //id 52                    VERIFICAR
        insertValues.add(values(new Ponto(53,1,new LatLng(-21.133884, -44.233165), "BAZAR SANTA INÉZ", "Ponto próximo ao supermercado Esquinão Bom Pastor","x"))); //id 53                    VERIFICAR
        insertValues.add(values(new Ponto(54,1,new LatLng(-21.133884, -44.233165), "AÇOUGUE DO MÁRIO", "Ponto próximo ao supermercado Esquinão Bom Pastor","x"))); //id 54                    VERIFICAR
        insertValues.add(values(new Ponto(55,1,new LatLng(-21.134689, -44.232235), "PONTO SEM IDENTIFICAÇÃO 3", "-","x"))); //id 55                    VERIFICAR, sei que existe já desci do ônibus lá
        insertValues.add(values(new Ponto(56,1,new LatLng(-21.134633, -44.232223), "PONTO SEM IDENTIFICAÇÃO 4", "-","y"))); //id 56                    VERIFICAR, sei que existe já peguei ônibus lá
        insertValues.add(values(new Ponto(57,1,new LatLng(-21.138503, -44.267474), "MERCEÁRIA SÃO JORGE", "Ponto próximo à praça N. Sra. de Fátima (estalagem)","y"))); //id 57
        insertValues.add(values(new Ponto(58,1,new LatLng(-21.138570, -44.267471), "ROSÁRIA CABELEIREIRA", "Ponto próximo à praça N. Sra. de Fátima (estalagem)","x"))); //id 58
        insertValues.add(values(new Ponto(59,1,new LatLng(-21.139243, -44.269040), "BAR TIA MARIA I", "Ponto próximo à casa do albergado","y"))); //id 59
        insertValues.add(values(new Ponto(60,1,new LatLng(-21.139269, -44.269286), "CASA DO ALBERGADO", "Ponto próximo à loja lagoa verde agropecuária","x"))); //id 60
        insertValues.add(values(new Ponto(61,1,new LatLng(-21.141718, -44.274106), "ROCHA’S MEC NICA", "Ponto próximo à igreja evangélica Assembléia de Deus","x"))); //id 61
        insertValues.add(values(new Ponto(62,1,new LatLng(-21.141924, -44.275936), "PONTO SEM IDENTIFICAÇÃO 5", "-","y"))); //id 62                    VERIFICAR
        insertValues.add(values(new Ponto(63,1,new LatLng(-21.139041, -44.266478), "PHYSICAL", "Ponto perto do club Minas Futebol Club","y"))); //id 63
        insertValues.add(values(new Ponto(64,1,new LatLng(-21.139639, -44.267621), "TV CAMPOS DE MINAS", "Ponto em frente à sede da TV Campo de Minas","x"))); //id 64
        insertValues.add(values(new Ponto(65,1,new LatLng(-21.139928, -44.268351), "PONTE DE FERRO", "Ponto em frente à rua que leva ao bairro São Caetano","y"))); //id 65
        insertValues.add(values(new Ponto(66,1,new LatLng(-21.142868, -44.273999), "IAGO PIMENTEL", "Ponto em frente à E. E. Prof. Iago Pimentel","x"))); //id 66
        insertValues.add(values(new Ponto(67,1,new LatLng(-21.142755, -44.274005), "E. E. PROF. IAGO PIMENTEL", "Ponto em frente à E. E. Prof. Iago Pimentel, do outro lado da rua","y"))); //id 67
        insertValues.add(values(new Ponto(68,1,new LatLng(-21.102383, -44.248321), "CTAN - BR", "Ponto em frente à UFSJ (campus CTAN), do outro lado da BR","x"))); //id 68                    VERIFICAR
        insertValues.add(values(new Ponto(69,1,new LatLng(-21.144965, -44.277684), "TREM DE MINAS", "Ponto em frente à fábrica de laticínios Trem de Minas","y"))); //id 69                    VERIFICAR
        insertValues.add(values(new Ponto(70,1,new LatLng(-21.144833, -44.277171), "FÁBRICA DE LATICÍNIOS", "Ponto em frente à fábrica de laticínios Trem de Minas, do outro lado da BR","x"))); //id 70                    VERIFICAR
        insertValues.add(values(new Ponto(71,1,new LatLng(-21.145323, -44.278465), "POINT BAR", "Ponto em frente ao Point Bar, do outro lado da BR","y"))); //id 71                    VERIFICAR
        insertValues.add(values(new Ponto(72,1,new LatLng(-21.145379, -44.278445), "POINT BAR (2)", "Ponto em frente ao Point Bar","x"))); //id 72                    VERIFICAR
        insertValues.add(values(new Ponto(73,1,new LatLng(-21.102513, -44.248354), "CTAN - BR (2)", "Ponto em frente à UFSJ (campus CTAN) na BR","y"))); //id 73                    VERIFICAR
        insertValues.add(values(new Ponto(74,1,new LatLng(-21.097447, -44.258624), "Indo pro Bengo - BR", "Ponto no caminho pro Bengo, no meio da BR","x"))); //id 74                    VERIFICAR
        insertValues.add(values(new Ponto(75,1,new LatLng(-21.089234, -44.263472), "Indo pro Bengo - BR (2)", "Ponto no caminho pro Bengo, no meio da BR","x"))); //id 75                    VERIFICAR
        insertValues.add(values(new Ponto(76,1,new LatLng(-21.085692, -44.264079), "Indo pro Bengo - BR (3)", "Ponto no caminho pro Bengo, no meio da BR","x"))); //id 76                    VERIFICAR
        insertValues.add(values(new Ponto(77,1,new LatLng(-21.083813, -44.266320), "ENTRADA DA CACHOEIRA 106", "Ponto no caminho pro Bengo, na virada que leva a cachoeira 106","x"))); //id 77                    VERIFICAR
        insertValues.add(values(new Ponto(78,1,new LatLng(-21.085430, -44.267361), "CACHOEIRA 106", "Ponto próximo à cachoeira 106 no Bengo","x"))); //id 78                    VERIFICAR
        insertValues.add(values(new Ponto(79,1,new LatLng(-21.111263, -44.237473), "IMAGENS SÃO JOANENSE", "Ponto próximo À FAEMAM Estanhos","x"))); //id 79
        insertValues.add(values(new Ponto(80,1,new LatLng(-21.111263, -44.237473), "EXPRESSO VERA CRUZ", "Ponto próximo ao Ferro Velho São João","y"))); //id 80
        insertValues.add(values(new Ponto(81,1,new LatLng(-21.107564, -44.231934), "IRMÃOS VIANINI", "Ponto em frente ao depósito Irmãos Vianini","x"))); //id 81
        insertValues.add(values(new Ponto(82,1,new LatLng(-21.105723, -44.229281), "KARINA", "Ponto próximo ao restaurante Karina","x"))); //id 82
        insertValues.add(values(new Ponto(83,1,new LatLng(-21.104032, -44.228519), "MEIO DA 31 DE MARÇO", "Ponto no meio da av. 31 de março","x"))); //id 83                    VERIFICAR
        insertValues.add(values(new Ponto(84,1,new LatLng(-21.100974, -44.228282), "ARGOS EXTINTORES", "Ponto próximo à gruta da Colônia","x"))); //id 84                    VERIFICAR
        insertValues.add(values(new Ponto(85,1,new LatLng(-21.101036, -44.228388), "GRUTA", "Ponto próximo à gruta da Colônia","y"))); //id 85                    VERIFICAR
        insertValues.add(values(new Ponto(86,1,new LatLng(-21.094304, -44.202717), "ÁGUAS SANTAS", "Ponto final da linha Alto das Águas","xy"))); //id 86                    têm vários pontos antes desse, porém a maioria não tem placa
        insertValues.add(values(new Ponto(87,1,new LatLng(-21.135944, -44.230604), "ART E MODA", "Ponto próximo ao posto do Bergão","y"))); //id 87
        insertValues.add(values(new Ponto(88,1,new LatLng(-21.136280, -44.230292), "ESTACIONAMENTO", "Ponto próximo ao posto do Bergão","x"))); //id 88
        insertValues.add(values(new Ponto(89,1,new LatLng(-21.138853, -44.229591), "POSTO PIO XII", "Ponto em frente ao posto Pio XII (do outro lado da avenida)","x"))); //id 89
        insertValues.add(values(new Ponto(90,1,new LatLng(-21.140016, -44.229497), "SACOLÃO PIO XII", "Ponto em frente ao Sacolão Pio XII (do outro lado da avenida)","y"))); //id 90
        insertValues.add(values(new Ponto(91,1,new LatLng(-21.140532, -44.229345), "CHÁCARA", "Ponto próximo ao Paulo e Eliana Móveis e Decorações (do outro lado da avenida)","y"))); //id 91
        insertValues.add(values(new Ponto(92,1,new LatLng(-21.141827, -44.228983), "SALÃO ESTILO BELEZA", "Ponto próximo ao Batista Alimentação (do outro lado da avenida)","x"))); //id 92
        insertValues.add(values(new Ponto(93,1,new LatLng(-21.141891, -44.228905), "BATISTA ALIMENTAÇÃO", "Ponto próximo ao Batista Alimentação","y"))); //id 93
        insertValues.add(values(new Ponto(94,1,new LatLng(-21.144184, -44.228175), "MERCEARIA TREVO", "Ponto próximo à Mercearia Trevo (do outro lado da avenida)","x"))); //id 94
        insertValues.add(values(new Ponto(95,1,new LatLng(-21.144132, -44.227951), "PONTO FINAL DO TREVO", "Ponto ao lado direito da Mercearia Trevo","xy"))); //id 95
        insertValues.add(values(new Ponto(96,1,new LatLng(-21.138296, -44.260325), "SÃO FRANCISCO - ESQUERDA", "Ponto próximo à UFSJ (campus Santo Antônio), do lado esquerdo da igreja","x"))); //id 96
// linhas 11
        insertValues.add(values(new Ponto(97,1,new LatLng(-21.138547, -44.260936), "SÃO FRANCISCO - DIREITA", "Ponto próximo à UFSJ (campus Santo Antônio), do lado direito da igreja","x"))); //id 97
// linhas 11
        insertValues.add(values(new Ponto(98,1,new LatLng(-21.103989, -44.228708),"CASA MODERNA","esquina da 31 de Março","y",0)));
        //3,4,5,16 cadastrado por usuario
        //
        insertValues.add(values(new Ponto(99,1,new LatLng(-21.13817633348187,-44.263251),"BIQUINHA (2)","Ponto próximo ao bar Tia Maria II","x",0)));
        insertValues.add(values(new Ponto(100,1,new LatLng(-21.128597,-44.239650999999995),"SHOPPING DAS CARNES","Ponto em frente à E. E. Tomé Portes del Rei","x",0)));
        insertValues.add(values(new Ponto(101,1,new LatLng(-21.129828,-44.2381999999996),"ANTIGA DELEGACIA","Ponto próximo ao JB Máquinas","y",0)));

        insertValues.add(values(new Ponto(102,1,new LatLng(-21.106285,-44.230159),"ANTÍQUOS METAIS ARTÍSTICO","Ponto perto da farmacia sta. Terezinha","y",0)));

        insertValues.add(values(new Ponto(103,1,new LatLng(-21.1151133,-44.2246172),"PONTO DE ÔNIBUS DA PRAÇA DA COHAB","Primeiro e Último ponto de ônibus do Bairro ","xy",0)));

        insertValues.add(values(new Ponto(104,1,new LatLng(-21.115008793550977,-44.22597952187061),"PONTO DE FRENTE AO DEPÓSITO ESQUINÃO","Ponto Próximo ao portão principal da Fundação Bradesco e de frente ao depósito Esquinão.","x",0)));
        insertValues.add(values(new Ponto(105,1,new LatLng(-21.127595,-44.240728999999995),"EXPRESSO MOTO TÁXI","Moto táxi início da Josué de Queiroz, Matosinhos. \n\nTelefone: 909033735330","xy",1)));
        insertValues.add(values(new Ponto(106,1,new LatLng(-21.126061198968866,-44.24643337726593),"MOTO TÁXI DA RODOVIÁRIA ","Moto táxi da rodoviária. \n\nTelefone:33733695",1)));
        insertValues.add(values(new Ponto(107,1,new LatLng(-21.125363782411814,-44.253011494874954),"BAR DO FUNGÃO","Esquina da Rua Aníbal José D'angelo","y",0)));
        insertValues.add(values(new Ponto(108,1,new LatLng(-21.124246345368462,-44.25067562609911),"IGREJA","Dom Bosco","y",0)));
        insertValues.add(values(new Ponto(109,1,new LatLng(-21.12756047708972,-44.23628490418196)," INOCOOP","Em frente ao INOCOOP","y",0)));
        insertValues.add(values(new Ponto(110,1,new LatLng(-21.144509646552162,-44.25440892577171),"TRAVESSA DA JOSÉ SANTANA","Ponto próximo a travessa que da acesso a Rua José Santana da Silva","y",0)));
        insertValues.add(values(new Ponto(111,1,new LatLng(-21.093104527772155,-44.21692740172147),"TEATRO DA PEDRA","Centro de Pesquisa em Arte e Educação","y",0)));
        insertValues.add(values(new Ponto(112,1,new LatLng(-21.145056250719936,-44.25728358328343),"POLO ART","Próximo ao POLO ART","x",0)));
        insertValues.add(values(new Ponto(113,1,new LatLng(-21.142221892349802,-44.258498623967164),"JOÃO DA MATA","Primeiro ponto da Rua João da Mata","y",0)));
        insertValues.add(values(new Ponto(114,1,new LatLng(-21.139041930382604,-44.259118884801865),"RUA MOURA FILHO","Ponto próximo a Rua Moura Filho","y",0)));
        insertValues.add(values(new Ponto(115,1,new LatLng(-21.12431108376447,-44.25920572131872),"SALÃO DO ARAÇÁ","Ponto ao lado do Salão","y",0)));
        insertValues.add(values(new Ponto(116,1,new LatLng(-21.12639520717178,-44.25513882189989),"Vereda Park","Ponto em frente o Vereda Park","y",0)));
        insertValues.add(values(new Ponto(117,1,new LatLng(-21.127242733972945,-44.25698887556791),"Igreja São Geraldo","Atrás da igreja São Geraldo","y",0)));
        insertValues.add(values(new Ponto(118,1,new LatLng(-21.125812256036166,-44.25772681832314),"PONTO ARAÇÁ","No início do morro da igreja São Geraldo","y",0)));
        insertValues.add(values(new Ponto(119,1,new LatLng(-21.14334669882381,-44.259227514266975),"ACESSO A JOÃO DA MATA","Ponto próximo a Rua João da Mata","x",0)));
        insertValues.add(values(new Ponto(120,1,new LatLng(-21.140747779415904,-44.25812043249607),"PRAÇA DO BONFIM SUBINDO","Ponto próximo a Praça do Bonfim","x",0)));
        insertValues.add(values(new Ponto(121,1,new LatLng(-21.139800574375602,-44.257972240448),"PRAÇA DO BONFIM","Ponto próximo a Praça do Bonfim","y",0)));
        insertValues.add(values(new Ponto(123,1,new LatLng(-21.143252887100683,-44.257645681500435),"CAPELA DO SENHOR DO BONFIM","Ponto próximo a Capela do Senhor do Bonfim","y",0)));
        insertValues.add(values(new Ponto(124,1,new LatLng(-21.14369536520743,-44.25576075911522),"ESCADARIA DO BONFIM","Ponto próximo a escadaria do Bonfim","y",0)));
        insertValues.add(values(new Ponto(125,1,new LatLng(-21.14552530303172,-44.2538208514452),"EXAME DE DIREÇÃO","Ponto próximo ao local de realização do exame de direção para primeira habilitação. ","y",0)));
        insertValues.add(values(new Ponto(126,1,new LatLng(-21.146432133289764,-44.25309631973504),"CAMPO DO ESPORTE CLUBE BONFIM","Ponto próximo ao Campo do Esporte Clube Bonfim","y",0)));
        insertValues.add(values(new Ponto(127,1,new LatLng(-21.148992804346268,-44.25256557762623),"TREVO DO BONFIM","Ponto na BR 265 na saída do Bairro Bonfim","y",0)));
        insertValues.add(values(new Ponto(128,1,new LatLng(-21.14776860335,-44.252147153019905),"CONDOMÍNIO DO BONFIM","Ponto próximo ao Condomínio do Bonfim","y",0)));
        insertValues.add(values(new Ponto(129,1,new LatLng(-21.126367373183612,-44.25505869090557),"PONTO VEREDA PARK HOTEL","ponto em frente ao hotel Vereda","x",0)));
        insertValues.add(values(new Ponto(130,1,new LatLng(-21.108271047913373,-44.22704368829727),"COPASA","Próximo ao escritorio da COPASA","x",0)));
        insertValues.add(values(new Ponto(131,1,new LatLng(-21.140098276975365,-44.2649882286787),"GUARDA MOR","Próxima a republica casarão","x",0)));
        insertValues.add(values(new Ponto(132,1,new LatLng(-21.136324,-44.262601),"IGREJA NOSSA SENHORA DO ROSÁRIO","Em frente à igreja, perto da casa pertencente à família do Tancredo Neves","x",0)));
        insertValues.add(values(new Ponto(133,1,new LatLng(-21.13428,-44.263087),"HOSPITAL","Ponto em frente ao hospital","x",0)));
        insertValues.add(values(new Ponto(134,1,new LatLng(-21.115008793550977,-44.22597952187061),"PONTO DE FRENTE AO DEPÓSITO ESQUINÃO","Ponto Próximo ao portão principal da Fundação Bradesco e de frente ao depósito Esquinão. ","x",0)));
    }
    private static void getDivi() {

    }
    /*ContentValues com as definições para serem armazenadas no Banco (Processo de facilitação) */
    private static ContentValues values(Ponto ponto){
        ContentValues values = new ContentValues();
        values.put("idPonto", ponto.getIdPonto());
        values.put("idCidade", ponto.getIdCidade());
        values.put("Lat", ponto.getLatLng().latitude);
        values.put("Lng", ponto.getLatLng().longitude);
        values.put("Title", ponto.getTitle());
        values.put("Description", ponto.getDescription());
        values.put("direcao", ponto.getDirecao());
        values.put("tipo", ponto.getTipo());
        return values;
    }


}
