package com.uce.edu.demo.service;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.uce.edu.demo.repository.IHabitacionRepository;
import com.uce.edu.demo.repository.IHotelRepository;
//import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;
import com.uce.edu.demo.repository.modelo.onetomany.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelRepository iHotelRepository;

//	@Autowired
//	private IHabitacionRepository iHabitacionRepository;

	@Override
	public void insertar(Hotel hotel) {
		/*
		 * List<Habitacion> habitaciones = hotel.getHabitaciones();
		 * hotel.setHabitaciones(null);
		 */
		this.iHotelRepository.insertar(hotel);

		/*
		 * //################################# //Buscar el hotel String numero =
		 * hotel.getNombre(); Hotel hotelBuscado = null; for(Habitacion habiItem :
		 * habitaciones) { //Calculos habiItem.setHotel(hotelBuscado);
		 * this.iHabitacionRepository.insertar(habiItem); }
		 * 
		 */

	}

}
