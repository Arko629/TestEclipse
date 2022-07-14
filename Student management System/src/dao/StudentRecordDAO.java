package dao;
import java.util.Scanner;

import Model.Record;
public interface StudentRecordDAO {
	public void add(Record r);
	public boolean find(int idNimber);
	public void delete(int recIdNumber);
	public Record findRecord(int idNumber);
	public void update(int id, Scanner input);
	public void display();
}
