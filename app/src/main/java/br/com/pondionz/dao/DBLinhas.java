package br.com.pondionz.dao;


import android.content.ContentValues;

import java.util.LinkedList;
import java.util.List;

import br.com.pondionz.model.Linha;

/**
 * Created by Iago on 09/03/2016.
 * //ultima linha a ser adicionada é a 101
 */
class DBLinhas {
    private final static double precoPresidente = 3.20,
            precoTrancid = 4.05,
            precoExdil = 4.05,
            precoTranspratur = 4.05,
            precoBraulino = 4.05,
            precoPresidenteLafaiete = 3.00,
            precoFormiga = 3.40;

    private static List<ContentValues> insertValues = new LinkedList<ContentValues>();
    public static List<ContentValues> getLinhas(){
        getSJDR();
        getDivi();
        getLafaiete();
        getSantaCruz();
        getFormiga();
        return insertValues;
    }

    private static void getSJDR() {
        insertValues.add(values(new Linha(1,"1 : CIDADE - TREVO","CIDADE","TREVO",precoPresidente,"Viação Presidente São João del Rey",1)));
        insertValues.add(values(new Linha(2,"2 : CIDADE - DIVISA DE SANTA CRUZ DE MINAS","CIDADE","COHAB",precoPresidente,"Viação Presidente São João del Rey",1)));
        insertValues.add(values(new Linha(3,"3 : TIJUCO - GIAROLA","TIJUCO","GIAROLA",precoPresidente,"Viação Presidente São João del Rey",1)));
        insertValues.add(values(new Linha(4,"4 : TIJUCO - ALTO DAS ÁGUAS","TIJUCO","ALTO DAS ÁGUAS",precoPresidente,"Viação Presidente São João del Rey",1)));
        insertValues.add(values(new Linha(5,"5 : TIJUCO - SOLAR DA SERRA","TIJUCO","SOLAR DA SERRA",precoPresidente,"Viação Presidente São João del Rey",1)));
        insertValues.add(values(new Linha(6,"6 : TIJUCO - BENGO","TIJUCO","BENGO",precoPresidente,"Viação Presidente São João del Rey",1)));
        insertValues.add(values(new Linha(7,"7 : TIJUCO - PIO XII/VIA LOMBÃO","TIJUCO","PIO XII",precoPresidente,"Viação Presidente São João del Rey",1)));
        insertValues.add(values(new Linha(8,"8 : TIJUCO/BARRO PRETO - PIO XII/VIA LOMBÃO","BARRO PRETO","PIO XII",precoPresidente,"Viação Presidente São João del Rey",1)));
        insertValues.add(values(new Linha(9,"9 : MAQUINÉ - GUARDA/MOR VIA DIV.SANTA CRUZ DE MINAS","MAQUINÉ","GUARDA/MOR",precoPresidente,"Viação Presidente São João del Rey",1)));
        insertValues.add(values(new Linha(10,"10 : SÃO JOÃO DEL REI - ELVAS","SÃO JOÃO DEL REI","ELVAS",precoPresidente,"Viação Presidente São João del Rey",1)));
        insertValues.add(values(new Linha(11,"11 : BONFIM/VARZEA DO FARIA - SENHOR DOS MONTES","BONFIM","SENHOR DOS MONTES",precoPresidente,"Viação Presidente São João del Rey",1)));
        insertValues.add(values(new Linha(14,"14 : HOSPITAL - CIRCULAR","HOSPITAL","HOSPITAL",precoPresidente,"Viação Presidente São João del Rey",1)));
        insertValues.add(values(new Linha(15,"15 : BIQUINHA - CTAN","BIQUINHA","CTAN",precoPresidente,"Viação Presidente São João del Rey",1)));
        insertValues.add(values(new Linha(16,"16 : AEROPORTO - FORÚM","AEROPORTO","FORÚM",precoPresidente,"Viação Presidente São João del Rey",1)));
        insertValues.add(values(new Linha(17,"17 : GUARDA/MOR - SOLAR DA SERRA","GUARDA/MOR","SOLAR DA SERRA",precoPresidente,"Viação Presidente São João del Rey",1)));
        insertValues.add(values(new Linha(18,"18 : GIRASSOL - GUARDA/MOR VIA DIV.SANTA CRUZ DE MINAS","GUARDA/MOR","GIRASSOL",precoPresidente,"Viação Presidente São João del Rey",1)));
        insertValues.add(values(new Linha(22,"22 : TREVO - FORÚM","FORÚM","TREVO",precoPresidente,"Viação Presidente São João del Rey",1)));
        insertValues.add(values(new Linha(95,"3517 : SÃO JOÃO DEL REI - TIRADENTES","SÃO JOÃO DEL REI","TIRADENTES",3.65,"Viação Presidente São João del Rey",1)));
      //   insertValues.add(values(new Linha(96,"SÃO JOÃO DEL REI - VALE NOVO","SÃO JOÃO DEL REI","VALE NOVO",3.65,"Viação Presidente São João del Rey",1)));
      //  insertValues.add(values(new Linha(97,"SÃO JOÃO DEL REI - SÃO SEBASTIÃO DA VÍTORIA","SÃO JOÃO DEL REI","SÃO SEBASTIÃO DA VÍTORIA",3.65,"Viação Presidente São João del Rey",1)));
      //  insertValues.add(values(new Linha(98,"SÃO JOÃO DEL REI - CESAR DE PINA","SÃO JOÃO DEL REI","CESAR DE PINA",3.65,"Viação Presidente São João del Rey",1)));
      //  insertValues.add(values(new Linha(99,"SÃO JOÃO DEL REI - VALE NOVO","SÃO JOÃO DEL REI","VALE NOVO",3.65,"Viação Presidente São João del Rey",1)));
      //  insertValues.add(values(new Linha(100,"CORUJÃO","CORUJÃO","CORUJÃO",3.65,"Viação Presidente São João del Rey",1)));


    }
    private static void getDivi() {
        insertValues.add(values(new Linha(23,"01 : BOM PASTOR - HALIM SOUKI","BOM PASTOR","HALIM SOUKI",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(24,"02 : DANILO PASSOS - BELA VISTA","BELA VISTA","DANILO PASSOS",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(25,"03 : SANTA TEREZA - JD DAS ACACIAS","SANTA TEREZA","JD DAS ACACIAS",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(26,"04 : PADRE EUSTAQUIO - CAMPINA VERDE","PADRE EUSTAQUIO","CAMPINA VERDE",precoTrancid,"Transoeste",2)));//falta essa
        insertValues.add(values(new Linha(27,"05 : ALVORADA - WALCHIR RESENDE","ALVORADA","WALCHIR RESENDE",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(28,"06 : MANOEL VALINHAS - SÃO MIGUEL","MANOEL VALINHAS","SÃO MIGUEL",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(29,"07 : NOVA FORTALEZA - DAVANUZE","DAVANUZE","NOVA FORTALEZA",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(30,"07A : NOSSA SENHORA DA CONCEICÃO - DAVANUZE","NOSSA SENHORA DA CONCEICÃO","DAVANUZE",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(31,"08 : FONTE BOA - COSTA AZUL","FONTE BOA","COSTA AZUL",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(32,"09 : HOSP. SÃO JOÃO DE DEUS - CAMPINA VERDE","HOSP. SÃO JOÃO DE DEUS","CAMPINA VERDE",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(33,"10 : J.A GONÇALVES - PADRE EUSTAQUIO","J.A GONÇALVES","PADRE EUSTAQUIO",precoTrancid,"Transoeste",2)));//falta esse
        insertValues.add(values(new Linha(34,"11 : VILA DAS ROSEIRAS - TIETE","VILA DAS ROSEIRAS","TIETE",precoTrancid,"Transoeste",2)));//falta esse
        insertValues.add(values(new Linha(35,"12 : ITAI - CONJ. NILDA BARROS","CONJ. NILDA BARROS","ITAI",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(36,"13 : VILA ROMANA - BELVEDERE","VILA ROMANA","BELVEDERE",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(37,"14 : CANDELARIA - JUSA FONSECA","CANDELARIA","JUSA FONSECA",precoTrancid,"Transoeste",2)));//falta esse
        insertValues.add(values(new Linha(38,"15 : SÃO ROQUE - PARAISO","SÃO ROQUE","PARAISO",precoTrancid,"Transoeste",2)));//falta esse
        insertValues.add(values(new Linha(39,"16 : SÃO SEBASTIÃO - MARIA HELENA","SÃO SEBASTIÃO","MARIA HELENA",precoTrancid,"Transoeste",2)));//parei aqui
        insertValues.add(values(new Linha(40,"17 : SERRA VERDE - ELIZABETE NOGUEIRA","SERRA VERDE","ELIZABETE NOGUEIRA",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(41,"19 : SERRA VERDE - JARDINOPOLIS","SERRA VERDE","JARDINOPOLIS",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(42,"20 : BELO VALE - COSTA AZUL","BELO VALE","COSTA AZUL",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(43,"21 : DANILO PASSOS - PADRE EUSTAQUIO","DANILO PASSOS","PADRE EUSTAQUIO",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(44,"22 : HALIM SOUKI - TIETE","HALIM SOUKI","TIETE",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(45,"23 : DANILO PASSOS - CACOCO","DANILO PASSOS","CACOCO",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(46,"24 : JUSA FONSECA - CONJ. NILDA BARROS","JUSA FONSECA","CONJ. NILDA BARROS",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(47,"25 : VILA ROMANA - SANTO ANDRE","VILA ROMANA","SANTO ANDRE",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(48,"26 : SANTA MARTA - VILA DAS ROSEIRAS","SANTA MARTA","VILA DAS ROSEIRAS",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(49,"27 : SÃO LUIZ - PADRE EUSTAQUIO","SÃO LUIZ","PADRE EUSTAQUIO",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(50,"28 : RINALDO CAMPOS - FERRADOR","RINALDO CAMPOS","FERRADOR",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(51,"30 : DANILO PASSOS - TEIXEIRA","DANILO PASSOS","TEIXEIRA",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(52,"31 : MARIA HELENA - COPACABANA","MARIA HELENA","COPACABANA",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(53,"32 : ELIZABETE NOGUEIRA - COPACABANA","ELIZABETE NOGUEIRA","COPACABANA",precoTrancid,"Transoeste",2)));
        insertValues.add(values(new Linha(54,"32A : FONTE BOA - COPACABANA","FONTE BOA","COPACABANA",precoTrancid,"Transoeste",2)));

        insertValues.add(values(new Linha(55,"41 : PLANALTO - CANDIDÉS(VIA NITERÓI)","PLANALTO","CANDIDÉS",precoExdil,"Transoeste",2)));
        insertValues.add(values(new Linha(56,"42 : PLANALTO - CANDIDÉS(VIA B. PASTOR)","PLANALTO","CANDIDÉS",precoExdil,"Transoeste",2)));
        insertValues.add(values(new Linha(57,"43 : PLANALTO - SÃO SIMÃO(VIA NITERÓI)","PLANALTO","SÃO SIMÃO",precoExdil,"Transoeste",2)));
        insertValues.add(values(new Linha(58,"44 : PLANALTO - GAFANHOTO","PLANALTO","GAFANHOTO",precoExdil,"Transoeste",2)));
        insertValues.add(values(new Linha(59,"45 : LAGOA DOS MANDARINS - NOVO PARAISO","LAGOA DOS MANDARINS","NOVO PARAISO",precoExdil,"Transoeste",2)));
        insertValues.add(values(new Linha(60,"46 : BOM PASTOR - HALIM SOUKI","BOM PASTOR","HALIM SOUKI",precoExdil,"Transoeste",2)));
        insertValues.add(values(new Linha(61,"47/48 : BURUTIS - CÓRREGO DO PAIOL","BURUTIS","CÓRREGO DO PAIOL",precoExdil,"Transoeste",2)));


        insertValues.add(values(new Linha(62,"61 : CENTRAL ABC - SANTA CRUZ","SANTA CRUZ","CENTRAL ABC",precoTranspratur,"Transoeste",2)));
        insertValues.add(values(new Linha(63,"62 : POSTO COELHO - PRIMAVERA","PRIMAVERA","POSTO COELHO",precoTranspratur,"Transoeste",2)));

        insertValues.add(values(new Linha(64,"51 : CLUBE DOS SERVIDORES MUNICIPAIS - LOPES","CLUBE DOS SERVIDORES MUNICIPAIS","LOPES",precoBraulino,"Transoeste",2)));
        insertValues.add(values(new Linha(65,"91 : HOSP. SANTA MÔNICA - CHORO","HOSP. SANTA MÔNICA","CHORO",precoBraulino,"Transoeste",2)));

    }

    private static void getLafaiete() {
        insertValues.add(values(new Linha(66,"0100 : LIMA DIAS - MOINHOS - SANTA MARIA - SÃO BENEDITO","LIMA DIAS","MOINHOS",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(67,"0101 : SION - GLOBO VEÍCULOS - SANTA TEREZINHA - SANTA CRUZ - BARREIRA","MOINHOS","GLOBO VEÍCULOS",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(68,"0200 : SANTA MATILDE - CACHOEIRA - OSCAR CORREIA","CACHOEIRA - OSCAR CORREIA","SANTA MATILDE",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(70,"0300 : MORRO DA MINA - PAULO VI","MORRO DA MINA","PAULO VI",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(71,"0400 : JARDIM EUROPA - TERMINAL","JARDIM EUROPA","TERMINAL",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(72,"0500 : GIGANTE - UNIPAC - ALMEIDAS","ALMEIDAS","PRAÇA SÃO SEBASTIÃO",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(73,"0600 : SATÉLITE - SÃO JOSÉ - REAL DE QUELUZ - BELA VISTA","SATÉLITE","SÃO JOSÉ",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(74,"0700 : SÃO DIMAS - SANTA EFIGÊNIA - JK - MORADA DO SOL"," MORADA DO SOL - JK","SÃO DIMAS",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(76,"0800 : TRIÂNGULO - REMONTA","TRIÂNGULO","REMONTA",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(77,"0801 : TERMINAL CENTRAL - SANTA EFIGÊNIA II","TERMINAL CENTRAL","SANTA EFIGÊNIA II",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(78,"0900 : CAPELA DA PAZ","CAPELA DA PAZ","PRAÇA SÃO SEBASTIÃO",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(79,"1000 : LINHAZINHA - PRAÇA SÃO SEBASTIÃO","LINHAZINHA","PRAÇA SÃO SEBASTIÃO",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(80,"1100 : SIDERÚRGICO - MUSEU - ANGÉLICA - ARCÁDIA ","SIDERÚRGICO","SANTO AGOSTINHO ANGÉLICA",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(81,"1200/1201 : ROCHEDO - SÃO SEBASTIÃO","SÃO SEBASTIÃO","ROCHEDO",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(82,"1300 : RODOVIÁRIA - BUARQUE DE MACEDO","RODOVIÁRIA","BUARQUE DE MACEDO",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(83,"1400 : RANCHO NOVO - SÃO SEBASTIÃO","SÃO SEBASTIÃO","RANCHO NOVO",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(84,"1500 : ARCÁDIA - MUSEU - SÃO SEBASTIÃO","SÃO SEBASTIÃO"," MUSEU/ARCÁDIA ",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(85,"1600 : SANTA ROSA - EXPEDICIONÁRIOS - GUARANI - MATERNIDADE","RODOVIÁRIA","EXPEDICIONÁRIOS",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(87,"1700 : DISTRITO INDUSTRIAL","BARREIRA","DISTRITO INDUSTRIAL",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(88,"1800 : SÃO VICENTE","SÃO VICENTE","TERMINAL CENTRAL",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(89,"2000 : SÃO GONÇALO","TERMINAL CENTRAL","SÃO GONÇALO",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(91,"2200 : MATO DENTRO","TRÊS BARRAS - MATO DENTRO","POLIVALENTE",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
        insertValues.add(values(new Linha(92,"2700 : POLIESPORTIVO - VILA RESENDE - SÃO JUDAS TADEU","POLIESPORTIVO","VILA RESENDE - SÃO JUDAS TADEU",precoPresidenteLafaiete,"Viação Presidente Lafaite",3)));
    }

    private static void getSantaCruz() {
        insertValues.add(values(new Linha(93,"SÃO JOÃO DEL REI - SANTA CRUZ DE MINAS","SÃO JOÃO DEL REI","SANTA CRUZ DE MINAS",3.00,"Viação Porto Real",4)));
        insertValues.add(values(new Linha(94,"SÃO JOÃO DEL REI - TIRADENTES","SÃO JOÃO DEL REI","TIRADENTES",4.20,"Viação Porto Real",4)));

    }
    private static void getFormiga() {
        insertValues.add(values(new Linha(101,"LINHA 01 – MARINGÁ / CENTRO","MARINGÁ","MARINGÁ",precoFormiga,"Viação Formiga",5)));
        insertValues.add(values(new Linha(102,"LINHA 02 – SOUZA E SILVA / ENGENHO DE SERRA","SOUZA E SILVA","ENGENHO DE SERRA",precoFormiga,"Viação Formiga",5)));
        insertValues.add(values(new Linha(103,"LINHA 03 – UNIFOR / CIDADE NOVA","UNIFOR","CIDADE NOVA",precoFormiga,"Viação Formiga",5)));
        insertValues.add(values(new Linha(104,"LINHA 04 – CIRCULAR","ROSA MÍSTICA","CRISTO",precoFormiga,"Viação Formiga",5)));
        insertValues.add(values(new Linha(105,"LINHA 05 – SANTA LUZIA / PLANALTO","SANTA LUZIA","PLANALTO",precoFormiga,"Viação Formiga",5)));
        insertValues.add(values(new Linha(106,"LINHA 06 – VILA NOVA DAS FORMIGAS / CENTRO","VILA NOVA DAS FORMIGAS","VILA NOVA DAS FORMIGAS",precoFormiga,"Viação Formiga",5)));
        insertValues.add(values(new Linha(107,"LINHA 07 – LIGEIRINHO","Unifor","Vila Nova",precoFormiga,"Viação Formiga",5)));

    }
    private static ContentValues values(Linha linha){
        ContentValues values = new ContentValues();
        values.put("idLinha", linha.getIdLinha());
        values.put("name", linha.getName());
        values.put("PontoX", linha.getPontoX());
        values.put("PontoY", linha.getPontoY());
        values.put("tarifa", linha.getTarifa());
        values.put("empresa", linha.getEmpresa());
        values.put("idCidade", linha.getCidade());
        return values;
    }

}
