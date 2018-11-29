import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        String str = "{highLightFlag:false, indexSource: 'pro',indexType:'accBankNameInfo',requestType:'AccBankNameVo',params:[{name:'bankName',value:'nong'ye',operate:'queryStringQuery',queryType:'must'},{name:'bankId',value:'103',operate:'termsQuery',queryType:'must'},{name:'standardAreaId',value:'3205',operate:'termsQuery',queryType:'must'}]";
        System.out.println(str.substring(0,134));
    }
}
