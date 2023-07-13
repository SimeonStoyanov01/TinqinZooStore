package com.example.tinqin.zoostore.service;

import com.example.tinqin.zoostore.API.request.*;
import com.example.tinqin.zoostore.API.response.*;

import java.util.List;

public interface VendorService {
    public VendorCreateResponse createVendor(VendorCreateRequest vendorCreateRequest);
    public VendorUpdateNameResponse updateVendorName(VendorUpdateNameRequest vendorUpdateRequest);

    public VendorUpdatePhoneResponse updateVendorPhoneNumber(VendorUpdatePhoneRequest vendorUpdateRequest);
    public VendorDeleteResponse deleteVendor(VendorDeleteRequest vendorDeleteRequest);

    public List<VendorGetAllByIdResponse> getAllVendors();
}
