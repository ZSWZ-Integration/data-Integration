package com.example.center_system.Service;

import javax.xml.transform.TransformerException;

public interface ElectiveService {

    String A_choose_B(String xml) throws TransformerException;

    String A_choose_C(String xml) throws TransformerException;

    String B_choose_A(String xml) throws TransformerException;

    String B_choose_C(String xml) throws TransformerException;

    String C_choose_A(String xml) throws TransformerException;

    String C_choose_B(String xml) throws TransformerException;

    String A_drop_B(String xml) throws TransformerException;

    String A_drop_C(String xml) throws TransformerException;

    String B_drop_A(String xml) throws TransformerException;

    String B_drop_C(String xml) throws TransformerException;

    String C_drop_A(String xml) throws TransformerException;

    String C_drop_B(String xml) throws TransformerException;

}
