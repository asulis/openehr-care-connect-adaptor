package com.inidus.platform.fhir.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class ObjectAdapter {

  public static JsonNode getExampleProcedure() throws IOException {
    String procedure = "[ " +
        "{ \"ehrId\" : \"0cec9cc7-98b9-4685-9177-70d14b3d2b32\", " +
        "\"subjectId\" : \"12345678\", " +
        "\"subjectNamespace\" : \"openehrtest\", " +
        "\"compositionStartTime\" : \"2020-08-05T13:46:44.995+00:00\", " +
        "\"compositionId\" : \"0321783b-18c2-47f1-9c68-e83966f2070f::local.ehrbase.org::1\", " +
        "\"composerName\" : \"Dr. Yamamoto\", " +
        "\"composerId\" : \"b4853825-aa22-4964-9026-e9f92e270249\", " +
        "\"composerNamespace\" : \"DEMOGRAPHIC\", " +
        "\"entryId\" : null, " +
        "\"Procedure_name_value\" : \"lQx hFyICSLpjVx bDZz.C HVOWTLMjApRgYAmkyeFyoy yfKLdaFveAWkxXHbuvmFGtXWTlqVZniOEakHCTIOGINzEtkZECuju,fpBanRgRwEEGjvFhnUvjjZEDfYhXpsLPNjuwkwfHhKExATPBqHZruFV,rDGNGPPMPuTB.pI,fxKMglwyHpkGypHktyIBsqANbPiQeKLVEkkSqUvNkaCnhAN.YyAbnIxNkFDcFdGMfkJalbBvKO.eBaOxfFh\",  "
        +
        "\"Procedure_name_code\" : null,  " +
        "\"Procedure_name_terminology\" : null,  " +
        "\"Outcome_value\" : \"BdWbKt,exBsKygHB,EhsbbxlXSUGTFPuBMAbhiVHAXPodJtiayqgrBYRUGqVCiclDXa,,hSxVuMuvcTwneGUsfa,OSQmDbgccjNPMfakdPPYqVdJAfLlBk,T,CEPKFoysOMoloQ XNsEk.GaOI bqjFDvxy DbZvIvpnWZzNYgGfHFsrGBmkTGr,Bdls.X.vjoaC,PvTxNKyytnBsSpuSNwkwrQddWYhNtqkBnkKkshHq,ZIbVpuTxGyAtTztcM\",  "
        +
        "\"Outcome_code\" : null,  " +
        "\"Outcome_terminology\" : null,  " +
        "\"Complication_value\" : \"ECB,yQUoyOnmyWilGmDvJwctVPaVwNcztJxeQTKboSWTnnPlhligDwqHsPVg,qCgsUrSzUztbJ,eFxQIpoiznNTBnKvceLWlRCtcukmRjhYvvoqokbgiTiODlMnicnkVWFXgsFKMgqvmnUDGjkWiQqchciQHjSKozpKlDmoiuVMAkiwSNyFjpejOIETe utIyjdWjeWHAGoKYpuZZyku,L SOTKhfPVYlOdKspEcccZPntJXqzwnZAHIOUXbNaN\",  "
        +
        "\"Complication_code\": null,  " +
        "\"Complication_terminology\": null,  " +//
        "\"Procedure_type\" : null," +
//        "\"name\": {  " +
//        "\"value\": \"Procedure type\"  " +
//        "}, " +
//        "\"value\": { " +
//        "\"value\": \"HSem kHN,pLIrjVNu DwGp IDiXLkFU.STwEoBPOmaNPTZz KvnNorMbYNTqwLQhfxjjffoENAsAUJILRwyhSvTzIFCKp brdrdR,rbxuihuFyWnPYiebKYOz,XmEwsiYRxrAoYvOvjmJWiumhFexG.zipRrCArMhGcBRmXhoVrHF olCCeAruMDpumrxOFkcCQiWNHQaVDdrfVgbhNADVhFLLQkPdLJa,IFEF xgsktolPkSlyqHsjliDelGox\",  "
//        +
//        "\"_type\": \"DV_TEXT\"  " +
//        "}" +
//        "\"_type\": \"ELEMENT\" " +
//        "}," +
        "\"Body_site_value\": null, " +
        "\"Body_site_code\": null, " +
        "\"Body_site_terminology\": null, " +
        "\"Reason_value\": \"qtrILweyZ,ygE,QyAyexSIvifObXmGJGqeLlrayYSzIumIfD.h,VNmvJpYUkSPp,hZf.fWIiYJybpMSiJedaCX,MNYOUptl.lGosMyuLJTIWYkGgMwAJaGdKczIdTwxSZk QqVmzTWSkUrAIkguPqBUsIBDrVnyyUyVZzLx.VO.cteGZcJIXjPqXCgiDitftJTKqsDZhgpLiAZUaCwXEvLSu.LooSeqmWbZOHZhKxu,F,wdbJ,CfsJTI\", "
        +
        "\"Reason_code\" : null, " +
        "\"Reason_terminology\" : null, " +
        "\"Comment\": \"FeU.oJr zmIpOwsKeeyUCHwfRKkZVPjUdiKvJWCpS vNmJzQdQxsdzljkIFMA. AwEmQoNE.GINqadnVZdT.LzhZkXKjJzycpziETnLYDtYK,pkDEjrK.Hu ByMVqaDQAINfC,HqpocYlSc,Z mpnOTzOmGyvWbypOmAEehsYAjPtKDVqEBHTuYwkDfgXFMksqGKZHUxwyqKyPTliJLRjxJWMFDDYpBSWEHXZ.YEpFuzZZSfqqYXNTusnrjMxOA\", "
        +

        "\"OtherParticipations\": null, " +
        "\"Procedure_time\": null, " +
        //"\"Procedure_time\":  \"{\"value\": \"2020-08-05T13:46:45.094Z\", \"epoch_offset\": 1596635205},"
        "\"Status_code\": null, " +
        "\"Careflow_step_code\": null, " +
        "\"Description\": \"ciqGiq,TEjzt rLwtJwu.VKAHokTFuJ.ZyCYGgIHaBqSqlErgfeoPZZqcLAWnligNvvYSRNgknTQYOZfhCUPPwO wGHbsYkcltlkJAyoHmvWNEGupVCiqjxNSHW.tlIGtRP.zTSmnPEc.iBmWVEcpxsVP EeuWhyMQIxaLhjYfnzHVsMefHhyOdVHT,yfse ,QsQayFOW.EnFhYc.mN,LuIFdvNZeqPUKfVZ.prkzOz.go TtryfPuTdyrlyycA\" "
        +
        "} " +
        "] ";
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readTree(procedure);
  }

//  public static void main (String[] args) throws IOException {
//    ObjectAdapter.getExampleProcedure();
//
//  }
  }
