package textfiles;

import java.io.File;
import java.io.IOException;

public class WSDLFilter {
    
public static String filterWSDL(File file) {
    StringBuffer OutputText = new StringBuffer();
    
    try{ 
        String bpel_name = file.getName();
        String file_path = file.getAbsolutePath();
        StringBuffer NameErrorDisplay = new StringBuffer();
        StringBuffer IncorrectNamespace = new StringBuffer();
        StringBuffer IncorrectOperationNames = new StringBuffer();
        ReadFile textFile=new ReadFile (file_path);
        String[] aryLines = textFile.OpenFile();
        WordCounter countWords= new  WordCounter();
        RegexModule Regex = new RegexModule();
        
        //Check WSDL Name
        if (countWords.countCapitals(bpel_name)> 9){
            NameErrorDisplay.append("   - This WSDL's name does not follow the correct naming standard because the words in the name are greater than 4 (");
            NameErrorDisplay.append(countWords.countCapitals(bpel_name));
            NameErrorDisplay.append(" words).\n");
            }
        
        int i;
        for ( i=0; i < aryLines.length; i++ ) {
            //Check Namespace
            if ((Regex.regexContains("^(<definitions)?.?targetnamespace=\"", aryLines[i].toLowerCase().trim()) == true) && (Regex.regexContains("http://www.americanexpress.com", aryLines[i]) == false)){
                IncorrectNamespace.append("       " + aryLines[i].trim() + "\n");
                }
            if ((aryLines[i].toLowerCase().trim().startsWith("<wsdl:operation"))&&(aryLines[i+1].toLowerCase().trim().startsWith("<wsdl:input"))&&(Regex.regexContains("name=\"[a-z]", aryLines[i]) == false)){
                IncorrectOperationNames.append("       " + aryLines[i].trim() + "\n");
                }
            }
        //Result Printing  
        
        if ((NameErrorDisplay.length() > 0)||(IncorrectNamespace.length() > 0)||(IncorrectOperationNames.length() > 0)) {
            StringBuffer PathDisplay = new StringBuffer(file_path + "\n");
            OutputText.append(PathDisplay);
            if (NameErrorDisplay.length() > 0){
                OutputText.append(NameErrorDisplay);
                }
            if (IncorrectNamespace.length() > 0){
                OutputText.append("   - This WSDL contains an improper namespace:\n" + IncorrectNamespace);
                }
            if (IncorrectOperationNames.length() > 0){
                OutputText.append("   - This WSDL contains non camelcased opperation names:\n" + IncorrectOperationNames);
                }
            }
        }
    catch (IOException e) {
        System.out.println( e.getMessage() );
        }
    String Output = OutputText.toString();
    return Output.trim();
    }
}