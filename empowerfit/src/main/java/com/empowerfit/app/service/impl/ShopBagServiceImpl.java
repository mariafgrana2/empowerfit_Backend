package com.empowerfit.app.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;


import com.empowerfit.app.model.ShopBag;
import com.empowerfit.app.repository.ShopBagRepository;
import com.empowerfit.app.service.ShopBagService;

@Service
public class ShopBagServiceImpl implements ShopBagService {

    private final ShopBagRepository shopBagRepository;

    // Constructor para inyección de dependencias
    public ShopBagServiceImpl(ShopBagRepository shopBagRepository) {
        this.shopBagRepository = shopBagRepository;
    }

    @Override
    public ShopBag createShopBag(ShopBag shopBag) {
        // Validar que la cantidad y el monto sean válidos
        if (shopBag.getQuantity() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero.");
        }
        if (shopBag.getAmount() <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }

        // Guardar la nueva bolsa de compras
        return shopBagRepository.save(shopBag);
    }

    @Override
    public List<ShopBag> getShopBagsByOrderId(Long orderId) {
        // Obtener bolsas de compras asociadas a un ID de orden
        return shopBagRepository.findById_OrderId(orderId);
    }

    @Override
    public List<ShopBag> getAllShopBags() {
        // Obtener todas las bolsas de compras
        return (List<ShopBag>) shopBagRepository.findAll();
    }

    @Override
    public List<ShopBag> getShopBagsByDate(LocalDate date) {
        // Filtrar bolsas de compras por la fecha asociada al pedido
        return shopBagRepository.findById_Date(date);
    }

    @Override
    public void updateShopBagsForOrder(List<ShopBag> shopBags, Long orderId) {
        // Eliminar bolsas de compras existentes para la orden especificada
        deleteShopBagsByOrderId(orderId);

        // Asociar nuevas bolsas de compras con la orden
        for (ShopBag shopBag : shopBags) {
            shopBag.getId().setOrderId(orderId); // Establecer la relación con la orden
            shopBagRepository.save(shopBag);
        }
    }

	@Override
	public void deleteShopBagsByOrderId(Long orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteShopBag(Long id) {
		// TODO Auto-generated method stub
		
	}

}

