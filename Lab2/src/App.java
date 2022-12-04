import entity.Appliance;
import entity.criteria.Criteria;
import entity.criteria.SearchCriteria;
import service.ApplianceService;
import service.ServiceFactory;
import main.PrintApplianceInfo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {

    public static void main(String[] args) {
        ApplianceService service = ServiceFactory.getInstance().getApplianceService();
        List<Appliance> list = new ArrayList<Appliance>();

        Criteria laptopCriteria = new Criteria(SearchCriteria.Laptop.class.getSimpleName());
        List<Appliance> laptops = service.find(laptopCriteria);
        list.addAll(laptops);

        Criteria refrigeratorCriteria = new Criteria(SearchCriteria.Refrigerator.class.getSimpleName());
        List<Appliance> refrigerators = service.find(refrigeratorCriteria);
        list.addAll(refrigerators);

				Criteria kettleCriteria = new Criteria(SearchCriteria.Kettle.class.getSimpleName());
        List<Appliance> kettles = service.find(kettleCriteria);
        list.addAll(kettles);

        Criteria vcCriteria = new Criteria(SearchCriteria.VacuumCleaner.class.getSimpleName());
        List<Appliance> vcs = service.find(vcCriteria);
        list.addAll(vcs);

        List<Appliance> minPriceAppliances = service.getMin(Comparator.comparing(Appliance::getPrice), list);
        if (minPriceAppliances != null) {
            System.out.println("Самые дешевые товары: ");
            PrintApplianceInfo.print(minPriceAppliances);
        }

				System.out.println("\nЧайники:");
				PrintApplianceInfo.print(kettles);


    }
}