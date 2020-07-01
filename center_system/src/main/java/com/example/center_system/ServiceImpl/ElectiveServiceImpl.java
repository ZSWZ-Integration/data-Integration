package com.example.center_system.ServiceImpl;

import com.example.center_system.Service.ElectiveService;
import com.example.center_system.Service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;

@Service
public class ElectiveServiceImpl implements ElectiveService {

    @Autowired
    TransferService transferService;

    @Override
    public String A_choose_B(String xml) throws TransformerException {
        String post = transferService.xmlTransfer(xml, "src\\main\\resources\\xslt\\elective\\AtoB.xslt").substring(38);
        try{
            return transferService.postRequest(post, "B_uri");
        } catch (Exception e){
            return "post error!";
        }
    }

    @Override
    public String A_choose_C(String xml) throws TransformerException {
        String post = transferService.xmlTransfer(xml, "src\\main\\resources\\xslt\\elective\\AtoC.xslt");
        try{
            return transferService.postRequest(post, "http://localhost:8082/othersAddCourse");
        } catch (Exception e){
            return "post error!";
        }
    }

    @Override
    public String B_choose_A(String xml) throws TransformerException {
        String post = transferService.xmlTransfer(xml, "src\\main\\resources\\xslt\\elective\\BtoA.xslt");
        try{
            return transferService.postRequest(post, "http://localhost:8081/othersAddCourse");
        } catch (Exception e){
            return "post error!";
        }
    }

    @Override
    public String B_choose_C(String xml) throws TransformerException {
        String post = transferService.xmlTransfer(xml, "src\\main\\resources\\xslt\\elective\\BtoC.xslt");
        try{
            return transferService.postRequest(post, "http://localhost:8082/othersAddCourse");
        } catch (Exception e){
            return "post error!";
        }
    }

    @Override
    public String C_choose_A(String xml) throws TransformerException {
        String post = transferService.xmlTransfer(xml, "src\\main\\resources\\xslt\\elective\\CtoA.xslt");
        try{
            return transferService.postRequest(post, "http://localhost:8081/othersAddCourse");
        } catch (Exception e){
            return "post error!";
        }
    }

    @Override
    public String C_choose_B(String xml) throws TransformerException {
        String post = transferService.xmlTransfer(xml, "src\\main\\resources\\xslt\\elective\\CtoB.xslt").substring(38);
        try{
            return transferService.postRequest(post, "B_uri");
        } catch (Exception e){
            return "post error!";
        }
    }

    @Override
    public String A_drop_B(String xml) throws TransformerException {
        String post = transferService.xmlTransfer(xml, "src\\main\\resources\\xslt\\elective\\AtoB.xslt").substring(38);
        try{
            return transferService.postRequest(post, "B_uri");
        } catch (Exception e){
            return "post error!";
        }
    }

    @Override
    public String A_drop_C(String xml) throws TransformerException {
        String post = transferService.xmlTransfer(xml, "src\\main\\resources\\xslt\\elective\\AtoC.xslt");
        try{
            return transferService.postRequest(post, "http://localhost:8082/othersDropCourse");
        } catch (Exception e){
            return "post error!";
        }
    }

    @Override
    public String B_drop_A(String xml) throws TransformerException {
        String post = transferService.xmlTransfer(xml, "src\\main\\resources\\xslt\\elective\\BtoA.xslt");
        try{
            return transferService.postRequest(post, "http://localhost:8081/othersDropCourse");
        } catch (Exception e){
            return "post error!";
        }
    }

    @Override
    public String B_drop_C(String xml) throws TransformerException {
        String post = transferService.xmlTransfer(xml, "src\\main\\resources\\xslt\\elective\\BtoC.xslt");
        try{
            return transferService.postRequest(post, "http://localhost:8082/othersDropCourse");
        } catch (Exception e){
            return "post error!";
        }
    }

    @Override
    public String C_drop_A(String xml) throws TransformerException {
        String post = transferService.xmlTransfer(xml, "src\\main\\resources\\xslt\\elective\\CtoA.xslt");
        try{
            return transferService.postRequest(post, "http://localhost:8081/othersDropCourse");
        } catch (Exception e){
            return "post error!";
        }
    }

    @Override
    public String C_drop_B(String xml) throws TransformerException {
        String post = transferService.xmlTransfer(xml, "src\\main\\resources\\xslt\\elective\\CtoB.xslt").substring(38);
        try{
            return transferService.postRequest(post, "B_uri");
        } catch (Exception e){
            return "post error!";
        }
    }
}
