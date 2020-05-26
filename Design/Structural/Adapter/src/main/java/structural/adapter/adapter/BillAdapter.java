package structural.adapter.adapter;

import structural.adapter.common.BillService;
import structural.adapter.special.SurfingBillService;

public class BillAdapter extends BillService implements SurfingBillService {

    @Override
    public void generate() {
        create();
    }
}
