package me.feuerente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * This class is the code behind the user view.
 * The user view consists of the FXML definition in user.fxml, the view-model in {@link UserViewModel}
 * and this class which binds the two together.
 */
public class UserController implements Initializable {

    private final UserViewModel viewModel;

    @FXML
    private TextField tfLastName;
    @FXML
    private TextField tfFirstName;
    @FXML
    private TextField tfHeight;
    @FXML
    private Button btnAddUser;
    @FXML
    private Button btnRemoveUser;
    @FXML
    private DatePicker datePickerBirthday;
    @FXML
    private ChoiceBox<UserSearchProperty> cbSearchProperty;
    @FXML
    private TextField tfSearch;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnShowAll;
    @FXML
    private TableView<UserTableRow> tableViewUser;
    @FXML
    private TableColumn<UserTableRow, Integer> idColumn;
    @FXML
    private TableColumn<UserTableRow, String> firstNameColumn;
    @FXML
    private TableColumn<UserTableRow, String> lastNameColumn;
    @FXML
    private TableColumn<UserTableRow, Integer> heightColumn;
    @FXML
    private TableColumn<UserTableRow, LocalDate> birthdayColumn;

    /**
     * Class constructor.
     */
    public UserController() {
        this.viewModel = new UserViewModel();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTableView();
        initChoiceBox();
        bindViewModel();
    }

    private void initTableView() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        heightColumn.setCellValueFactory(new PropertyValueFactory<>("heightInCM"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));

        tableViewUser.setItems(viewModel.getUserData());
    }

    private void initChoiceBox() {
        cbSearchProperty.getItems().setAll(UserSearchProperty.values());
        cbSearchProperty.getSelectionModel().selectFirst();
    }

    private void bindViewModel() {
        this.tfFirstName.textProperty().bindBidirectional(viewModel.firstNameProperty());
        this.tfLastName.textProperty().bindBidirectional(viewModel.lastNameProperty());

        StringConverter<Number> heightConverter = new NumberStringConverter();
        this.tfHeight.textProperty().bindBidirectional(viewModel.heightInCMProperty(), heightConverter);
        this.tfSearch.textProperty().bindBidirectional(viewModel.searchQueryProperty());
        this.datePickerBirthday.valueProperty().bindBidirectional(viewModel.birthdayProperty());

        this.viewModel.selectedSearchPropertyProperty().bind(cbSearchProperty.getSelectionModel().selectedItemProperty());

        this.viewModel.selectedItemProperty().bind(tableViewUser.getSelectionModel().selectedItemProperty());
    }

    @FXML
    void addUser(ActionEvent event) {
        this.viewModel.addUser();
    }

    @FXML
    void removeUser(ActionEvent event) {
        this.viewModel.removeUser();
    }

    @FXML
    void search(ActionEvent event) {
        this.viewModel.search();
    }

    @FXML
    void showAllUsers(ActionEvent event) {
        this.viewModel.showAllUsers();
    }
}
