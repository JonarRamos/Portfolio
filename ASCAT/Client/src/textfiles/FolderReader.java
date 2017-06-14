package textfiles;

import java.io.File;


public class FolderReader {
    public static void main(String[] args) {
        
        String file_directory = "C:\\Users\\jonar.l.ramos\\Desktop\\Java";
                                
            File directory = new File(file_directory);
            MainFileReader(directory);
            }
        public static void MainFileReader(File directory){
    
            for ( File file : directory.listFiles()){
                if(file.isDirectory()){
                    MainFileReader(file);
                }
                else{
                    //BPELs
                    if (file.getName().toLowerCase().endsWith("bpel")){
                        BPELFilter filterbpel= new BPELFilter(file);
                        if (!filterbpel.filterBPEL().isEmpty()){
                            System.out.println(filterbpel.filterBPEL());
                        }
                    }
                    //XSDs
                    if (file.getName().toLowerCase().endsWith("xsd")){
                        XSDFilter filterxsd= new XSDFilter(file);
                        if (!filterxsd.filterXSD().isEmpty()){
                            System.out.println(filterxsd.filterXSD());
                        }
                    }
                    //WSDLs
                    if (file.getName().toLowerCase().endsWith("wsdl") && !file.getName().toLowerCase().contains("wrapper") && !file.getName().contains("Ref")) {
                        WSDLFilter filterwsdl= new WSDLFilter();
                        if (!filterwsdl.filterWSDL(file).isEmpty()){
                            System.out.println(filterwsdl.filterWSDL(file));
                            }
                        }
                    }
                }
            }
        }
