import { Component, OnInit } from '@angular/core';
import { faUserEdit, faTrash } from '@fortawesome/free-solid-svg-icons';
import { Employee } from 'src/app/models/Employee';

import { EmployeeService } from '../../Services/employee.service';

import swal from 'sweetalert2';

@Component({
  selector: 'app-table-employess',
  templateUrl: './table-employess.component.html',
  styleUrls: ['./table-employess.component.scss'],
})
export class TableEmployessComponent implements OnInit {
  iconUserEdit = faUserEdit;
  iconUserDelete = faTrash;
  employee: Employee = { userName: '', fullName: '', appointment: '' };
  searchEmployee: Employee = {
    id: '',
    userName: '',
    fullName: '',
    appointment: '',
  };
  employees: Employee[] = [];

  constructor(private employeeService: EmployeeService) {}

  ngOnInit(): void {
    this.refreshDataTableEmployee();
  }

  refreshDataTableEmployee() {
    this.employeeService.getEmployees().subscribe(
      (res) => {
        this.employees = res;
        console.log(res);
      },
      (err) => console.log(err)
    );
  }
  createEmployee() {
    this.employeeService.createEmployee(this.employee).subscribe(
      (res) => {
        console.log(res);
        this.clearForm();
      },
      (err) => {
        console.error(err);
      }
    );
    swal.fire({
      position: 'center',
      icon: 'success',
      title: 'Employee successfully created',
      showConfirmButton: true,
    });

    this.refreshDataTableEmployee();
  }

  clearForm() {
    this.employee = { userName: '', fullName: '', appointment: '' };
  }

  editEmployee(id: any) {
    this.employeeService.getEmployee(id).subscribe(
      (res) => {
        this.searchEmployee = res;
      },
      (err) => console.log(err)
    );

    if (this.searchEmployee === null) {
      alert('Employee not found');
    }

    console.log(this.searchEmployee);
  }

  deleteEmployee(id: any) {
    swal
      .fire({
        title: 'Are you sure you want to delete the employee?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!',
      })
      .then((result) => {
        if (result.isConfirmed) {
          this.employeeService.deleteEmployee(id).subscribe(
            (res) => {
              alert('Employee deleted successfully');
            },
            (err) => console.log(err)
          );

          swal.fire('Deleted!', 'Employee has been deleted.', 'success');
          this.refreshDataTableEmployee();
        }
      });
  }
}
