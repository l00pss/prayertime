package org.namazvaxti.prayertimews.api.json;

import org.namazvaxti.prayertimews.client.abstracts.ClientServer;
import org.namazvaxti.prayertimews.client.concretes.ClientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/json/1.0/dailytime")
public class TimeControllerDailyAsJson {


    @Autowired
    ClientManager clientManager;

    @GetMapping("/test")
    public String Test() throws IOException {
        clientManager.writerToLocalRepository();
        return "TEDST";
    }
}
