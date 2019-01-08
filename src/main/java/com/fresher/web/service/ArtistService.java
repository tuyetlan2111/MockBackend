package com.fresher.web.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fresher.web.entity.Artist;

public interface ArtistService extends JpaRepository<Artist, Integer>{

}
