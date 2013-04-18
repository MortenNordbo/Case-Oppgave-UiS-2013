package TriDTegning;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Group;
import javax.media.j3d.Material;
import javax.media.j3d.PointLight;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;


import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.picking.PickCanvas;
import com.sun.j3d.utils.picking.PickResult;
import com.sun.j3d.utils.picking.PickTool;
import com.sun.j3d.utils.universe.SimpleUniverse;

import model.Entities.PricePoint;

public class SoyleGraf extends JPanel implements MouseListener
{

	PickCanvas pc;
	ArrayList<ArrayList<PricePoint>> DataFieldValue;
	Canvas3D cv;
	
	Cylinder cyl;

	Cylinder cyl1;

	Cylinder cyl2;

	Cylinder cyl3;
	public SoyleGraf(ArrayList<ArrayList<PricePoint>> data)
	{
		DataFieldValue = data;
		GraphicsConfiguration gc = SimpleUniverse.getPreferredConfiguration();
		cv = new Canvas3D(gc);
		setLayout(new BorderLayout());
		add(cv, BorderLayout.CENTER);
		cv.addMouseListener(this);
		
	    BranchGroup bg = createStill();
		bg.compile();
		pc = new PickCanvas(cv, bg);
	    pc.setMode(PickTool.GEOMETRY);
		SimpleUniverse su = new SimpleUniverse(cv);
		su.getViewingPlatform().setNominalViewingTransform();
		su.addBranchGraph(bg);
	}

	public BranchGroup createStill()
	{
		BranchGroup root = new BranchGroup();
		Transform3D tr = new Transform3D();
		TransformGroup tg;
		TransformGroup tg1;
		TransformGroup tg2;
		TransformGroup tg3;
		TransformGroup tgAxes;
		TransformGroup TGHolder = new TransformGroup();

		
		Group shape = new Axes();

		Appearance ap = new Appearance();
		ap.setMaterial(new Material());

		tr.setScale(0.02f);
		tr.setTranslation(new Vector3d(-0.5,(((double) DataFieldValue.get(0).get(DataFieldValue.get(0).size()-1).getPrice())/100)-0.3,0));
		tg = new TransformGroup(tr);
		tr.setIdentity();

		tr.setScale(0.02f);
		tr.setTranslation(new Vector3d(-0.25,(((double) DataFieldValue.get(1).get(DataFieldValue.get(1).size()-1).getPrice())/100)-0.3,0));
		tg1 = new TransformGroup(tr);
		tr.setIdentity();

		tr.setScale(0.02f);
		tr.setTranslation(new Vector3d(0,(((double) DataFieldValue.get(2).get(DataFieldValue.get(2).size()-1).getPrice())/100)-0.3,0));
		tg2 = new TransformGroup(tr);
		tr.setIdentity();

		tr.setScale(0.02f);
		tr.setTranslation(new Vector3d(0.25,(((double) DataFieldValue.get(3).get(DataFieldValue.get(3).size()-1).getPrice())/100)-0.3,0));
		tg3 = new TransformGroup(tr);
		tr.setIdentity();

		tr.setScale(0.5f);
		tr.setTranslation(new Vector3d(-0.75,0,0));
		tgAxes = new TransformGroup(tr);
		
		cyl = new Cylinder(1f, (float) DataFieldValue.get(0).get(DataFieldValue.get(0).size()-1).getPrice(), ap);
		cyl1 = new Cylinder(1f, (float) DataFieldValue.get(1).get(DataFieldValue.get(1).size()-1).getPrice(), ap);	
		cyl2 = new Cylinder(1f, (float) DataFieldValue.get(2).get(DataFieldValue.get(2).size()-1).getPrice(), ap);
		cyl3 = new Cylinder(1f, (float) DataFieldValue.get(3).get(DataFieldValue.get(3).size()-1).getPrice(), ap);
		
		cyl.setName("0");
		cyl1.setName("1");
		cyl2.setName("2");
		cyl3.setName("3");
		
		BoundingSphere bounds = new BoundingSphere();

	    PickTool.setCapabilities(cyl.getShape(Cylinder.BODY), PickTool.INTERSECT_TEST);
	    
	    PickTool.setCapabilities(cyl1.getShape(Cylinder.BODY), PickTool.INTERSECT_TEST);

	    PickTool.setCapabilities(cyl2.getShape(Cylinder.BODY), PickTool.INTERSECT_TEST);

	    PickTool.setCapabilities(cyl3.getShape(Cylinder.BODY), PickTool.INTERSECT_TEST);


		Background background = new Background(1.0f, 1.0f, 1.0f);
		background.setApplicationBounds(bounds);

		PointLight ptlight = new PointLight(new Color3f(Color.green), 
				new Point3f(3f,3f,3f), new Point3f(1f,0f,0f));
		ptlight.setInfluencingBounds(bounds);

		PointLight ptlight2 = new PointLight(new Color3f(Color.red),
				new Point3f(-2f,2f,2f), new Point3f(1f,0f,0f));
		ptlight2.setInfluencingBounds(bounds);


		root.addChild(TGHolder);
		root.addChild(background);
		root.addChild(ptlight2);
		root.addChild(ptlight);
		TGHolder.addChild(tg);
		TGHolder.addChild(tg1);
		TGHolder.addChild(tg2);
		TGHolder.addChild(tg3);
		TGHolder.addChild(tgAxes);
		tg.addChild(cyl);
		tg1.addChild(cyl1);
		tg2.addChild(cyl2);
		tg3.addChild(cyl3);
		tgAxes.addChild(shape);
		return root;

	}

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		
		pc.setShapeLocation(arg0);
	    PickResult results = pc.pickAny();
	    System.out.println(results.getObject().getParent().getName());
	    if(results.getObject().getParent().getName().equals("0"))
	    {
	    	JOptionPane.showMessageDialog(this, DataFieldValue.get(0).get(0).getEsid() + " "
	    									 +  DataFieldValue.get(0).get(DataFieldValue.get(0).size()-1).getPrice() + " "
	    			                         +  DataFieldValue.get(0).get(DataFieldValue.get(0).size()-1).getUnit());
	    }
	    if(results.getObject().getParent().getName().equals("1"))
	    {
	    	JOptionPane.showMessageDialog(this, DataFieldValue.get(1).get(0).getEsid() + " "
	    									 +  DataFieldValue.get(1).get(DataFieldValue.get(1).size()-1).getPrice() + " "
	    			                         +  DataFieldValue.get(1).get(DataFieldValue.get(1).size()-1).getUnit());
	    }
	    if(results.getObject().getParent().getName().equals("2"))
	    {
	    	JOptionPane.showMessageDialog(this, DataFieldValue.get(2).get(0).getEsid() + " "
	    									 +  DataFieldValue.get(2).get(DataFieldValue.get(2).size()-1).getPrice() + " "
	    			                         +  DataFieldValue.get(2).get(DataFieldValue.get(2).size()-1).getUnit());
	    }
	    if(results.getObject().getParent().getName().equals("3"))
	    {
	    	JOptionPane.showMessageDialog(this, DataFieldValue.get(3).get(0).getEsid() + " "
	    									 +  DataFieldValue.get(3).get(DataFieldValue.get(3).size()-1).getPrice() + " "
	    			                         +  DataFieldValue.get(3).get(DataFieldValue.get(3).size()-1).getUnit());
	    }
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
