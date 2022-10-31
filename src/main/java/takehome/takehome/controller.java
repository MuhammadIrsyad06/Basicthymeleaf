/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takehome.takehome;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author lenovo
 */
@Controller
public class controller {
    @RequestMapping("/home")
    public String inputData(@RequestParam(value="inputnama") String nama,
                            @RequestParam(value="inputtanggal") String tanggal,
                            @RequestParam(value="inputgambar") MultipartFile foto,
                            Model model)
            throws IOException{
        byte[] gambar = foto.getBytes();
        String base64Image = Base64.encodeBase64String(gambar);
        String gambarlink ="data:image/png;base64,".concat(base64Image);
        model.addAttribute("sendnama", nama);
        model.addAttribute("sendtanggal", tanggal);
        model.addAttribute("sendfoto",gambarlink);
        return "view";
    }
}
