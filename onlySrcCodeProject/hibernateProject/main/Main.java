package onlySrcCode.onlySrcCodeProject.hibernateProject.main;

import java.util.List;

import javax.xml.transform.Templates;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import onlySrcCode.onlySrcCodeProject.hibernateProject.data.Address;
import onlySrcCode.onlySrcCodeProject.hibernateProject.data.FourWheeler;
import onlySrcCode.onlySrcCodeProject.hibernateProject.data.TwoWheeler;
import onlySrcCode.onlySrcCodeProject.hibernateProject.data.User;
import onlySrcCode.onlySrcCodeProject.hibernateProject.data.Vehicle;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Address address = new Address();
		address.setStreet("street name");
		address.setCity("city");
		Address address2 = new Address();
		address2.setStreet("street name 2");
		address2.setCity("city 2");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("car");
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("bus");
		
		Vehicle vehicle3 = new Vehicle();
		vehicle3.setVehicleName("v3");
		
		
		
		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setSteeringHandle("handle");
		
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setSteeringWheel("wheel");
		
		User user = new User();
		user.setName("user 1");
		user.getAddressList().add(address);
		user.getAddressList().add(address2);
//		user.setVehicle(vehicle);
		user.getVehicleList().add(vehicle);
		user.getVehicleList().add(vehicle2);
		
		vehicle.getUserList().add(user);
		vehicle2.getUserList().add(user);
		
		//creating connection using hibernate.cfg.xml
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.save(vehicle2);
		session.save(vehicle3);
		session.save(twoWheeler);
		session.save(fourWheeler);

		session.getTransaction().commit();
		session.close();
		
		session = factory.openSession();
		session.beginTransaction();
		User user1 = (User) session.get(User.class, 1);
		System.out.println("user name is :- "+user1.getName());
		System.out.println(user1.getAddressList().size());
		
		Vehicle vehicle_2 = session.get(Vehicle.class, 2);
		session.delete(twoWheeler);
		session.delete(vehicle3);
//		vehicle.setVehicleName("updated vehicle name");
//		session.update(vehicle);
		
		Query query = session.createQuery("from Vehicle");
//		query.setMaxResults(2);
//		query.setFirstResult(1);
		List<Vehicle> vehicleList = query.list();
		for (Vehicle vehicle4 : vehicleList) {
			System.out.println(vehicle4.getVehicleName()+",");
		}
		
		Query query1 = session.createQuery("select vehicleName from Vehicle where vehicleName = ? and vehicleId= :vid");
		query1.setString(0, "bus");
		query1.setInteger("vid", 3);

//		query.setMaxResults(2);
//		query.setFirstResult(1);
		List<String> vehicleNameList = query1.list();
		for (String name : vehicleNameList) {
			System.out.println(name+",");
		}
		
		Query query2 = session.getNamedQuery("Vehicle.vId");
		query2.setInteger(0, 2);
		System.out.println(((Vehicle)query2.list().get(0)).getVehicleName());
		
		Query query3 = session.getNamedQuery("Vehicle.name");
		query3.setString(0, "bus");
		System.out.println(((Vehicle)query3.list().get(0)).getVehicleName());
		
		Criteria criteria = session.createCriteria(Vehicle.class);
		criteria.add(Restrictions.eq("vehicleName", "car"));
		System.out.println(((Vehicle)criteria.list().get(0)).getVehicleName());

		Criteria criteria2 = session.createCriteria(Vehicle.class);
		criteria2.setProjection(Projections.property("vehicleName"));
		List vehicleNamelist = criteria2.list();
		for (Object name : vehicleNamelist) {
			System.out.println(name);
			
		}

		
		
		session.getTransaction().commit();

		session.close();

	}

}
