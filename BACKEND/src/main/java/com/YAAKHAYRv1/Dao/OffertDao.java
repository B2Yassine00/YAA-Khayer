package com.YAAKHAYRv1.Dao;

import com.YAAKHAYRv1.Dto.OffertResponseDto;
import com.YAAKHAYRv1.Models.Individu;
import com.YAAKHAYRv1.Models.Offert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OffertDao extends JpaRepository<Offert,Integer> {

    List<Offert> findAllByIndividu(Individu individu);
    @Query("select O from Offert O where O.etat=0")
    List<Offert> findNottaken();

    @Query("select O.type FROM Offert O")
    List<String> findAllTypes();

    @Query("select new com.YAAKHAYRv1.Dto.OffertResponseDto(O.id,D.title,D.description,D.image,D.date_publication,D.etat,O.quantite,O.type,O.individu.id) from Offert O join Don D ON O.id=D.id")
    List<OffertResponseDto> findAllO();

    @Query("select new com.YAAKHAYRv1.Dto.OffertResponseDto(O.id,D.title,D.description,D.image,D.date_publication,D.etat,O.quantite,O.type,O.individu.id) from Offert O join Don D ON O.id=D.id where O.id=:id")
    Optional <OffertResponseDto> findByid(@Param("id") Integer id);


}
