package org.namazvaxti.prayertimews.api.admin;


import org.namazvaxti.prayertimews.business.abstracts.DailyWordService;
import org.namazvaxti.prayertimews.core.utilities.result.DataResult;
import org.namazvaxti.prayertimews.core.utilities.result.success.SuccessDataResult;
import org.namazvaxti.prayertimews.dataAccess.abstracts.DailyWordRepository;
import org.namazvaxti.prayertimews.entities.concretes.DailyWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/dailyword/admin/json/1.0")
public class DailyWordForAdmin {
    private DailyWordService service;

    @Autowired
    public DailyWordForAdmin(DailyWordService service) {
        this.service = service;
    }

    @GetMapping("/addWord")
    public ResponseEntity<DataResult<DailyWord>> insert(@RequestParam DailyWord context){


        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
