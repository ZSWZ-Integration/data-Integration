package com.example.center_system.Service;

import javax.xml.transform.TransformerException;
import java.io.IOException;

public interface ShareService {

    String AGetSharedCourse() throws IOException, TransformerException;

    String BGetSharedCourse() throws IOException, TransformerException;

    String CGetSharedCourse() throws IOException, TransformerException;

}
