package structural.adapter.adapter;

import structural.adapter.common.BillService;
import structural.adapter.special.SurfingBillService;

public class SurfingBillAdapter implements SurfingBillService {

    private BillService billService;

    public SurfingBillAdapter(BillService service) {
        this.billService = service;
    }

    @Override
    public void generate() {
        this.billService.create();
    }
}
