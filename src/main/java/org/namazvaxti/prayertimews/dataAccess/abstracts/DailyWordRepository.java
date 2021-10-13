package org.namazvaxti.prayertimews.dataAccess.abstracts;

import org.namazvaxti.prayertimews.entities.concretes.DailyWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DailyWordRepository extends JpaRepository<DailyWord, Long> {

}
